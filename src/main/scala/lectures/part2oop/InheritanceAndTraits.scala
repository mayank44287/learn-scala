package lectures.part2oop

object InheritanceAndTraits extends App {
  class Animal {
    //Access modifiers
    // protected =  accessible within inherited class
    //private = accessible from within the class only
    def eat = println("nonmnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  //constructors
  class Person(name: String, age: Int){
    def this(name:String) = this(name,0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)


  //overriding
  class Dog extends Animal{
    override def eat: Unit = println("crunch crunch")
  }

  //use super to access parent class methods

  //Preventing overrides
  //1. use final on the member
  //2. use final on the entire class
  //3. use sealed keyword for the class, it allows to extend the class in the same file, but can't extend out of the file s
}
