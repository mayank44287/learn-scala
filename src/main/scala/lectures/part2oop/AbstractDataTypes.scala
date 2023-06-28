package lectures.part2oop

object AbstractDataTypes extends App {
  //abstract
  //abstract classes can have both abstract and non abstract members
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    val creatureType: String = "Canine"

    //for abstract classes subclasses, override keyword need not be explicit while overriding the methods
    def eat: Unit = println("crunch crunch")
  }

  //traits can have both abstract and non abstract members
  trait Carnivore{
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    val creatureType: String = "croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"I'am a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // Diff bw trait and abstract class
  // 1. traits do not have constructor parameters
  // 2. multiple traits may be inherited by the same class
  // 3. traits - usually denotes "behaviour", abstract class - usually denotes the "thing" you are inheriting from
  //Scala has its own answer to the diamond problem - it's called a linearization. We explore that in depth in the
  // advanced course. As a short example, if you mix-in two traits which have the same method implementation,
  // the last one to be mixed-in is the one whose method will be used.
}
