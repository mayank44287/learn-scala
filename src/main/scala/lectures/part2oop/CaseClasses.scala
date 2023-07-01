package lectures.part2oop

object CaseClasses extends App{

  /* 1. equals, hashcode, toString
  *  2. class parameters are promoted to class fields
  *  3. println(jim) == println(jim.toString) -> syntactic sugar
  *  4. equals and hashcode implemented out of the box
  *  5. Have handy copy method
  *  6. have companion objects
  *  7. CC's are serializable
  *  8. CC's have extractor patterns = CC's acn be used in pattern matching
  * */
  case class Person(name: String, age: Int)

  //class parameters are promoted to class fields
  val jim = Person("Mayank", 31)
  println(jim.name)

  //equals and hashcode implemented out of the box
  val jim2 = Person("Jim", 33)
  println(jim == jim2)

  //Have handy copy method
  val jim3 = jim2.copy(age=40)
  println(jim3.toString)

  // have companion objects
  val thePerson = Person
  val mary = Person("Mary",39)

  //CC's are serializable
  //CC's have extractor patterns = CC's acn be used in pattern matching
  /*
     Expand MyList - use case classes and case objects
    */
}
