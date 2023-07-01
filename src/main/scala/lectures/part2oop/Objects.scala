package lectures.part2oop

object Objects extends App {

  //SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("NO STATIC")

  object Person {
    //"static"/"class" level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    //factory method
    def apply(mother: Person, father: Person) : Person = new Person("Bobbie");
  }

  //Scala object = Singleton instance
  class Person(val name: String) {
    // instance level functionality
  }
  //companion class for object Person

  val mary = Person
  val john = Person
  println(mary == john)
  val maya = new Person("Maya")
  val jaya = new Person("Maya")

  println(maya == jaya)
  //val bobbie = Person.apply(maya,jaya)
  val bobbie = Person(maya,jaya)
  println(bobbie.name)

  //Scala Applicaiton  = Scala Object with
  //def main(args:Array[String]): Unit
}
