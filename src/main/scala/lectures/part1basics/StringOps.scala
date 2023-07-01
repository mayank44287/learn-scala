package lectures.part1basics

object StringOps extends App{

  val aString: String = "Hello, My name is Mayank Raj."

  println(aString.charAt(2))
  println(aString.substring(7,11))
  println(aString.split(" ").toList)
  println(aString.startsWith("Hello"))
  println(aString.replace(" ","-"))
  println(aString.toLowerCase())
  println(aString.length)

  val aNumberString = "2"
  val aNumber = aNumberString.toInt
  println("a" +: aNumberString :+ "z")
  println(aString.reverse)
  println(aString.take(2))


  //Scala specific: String Interpolators

  //S-Interpolators

  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old "

  println(greeting)
  println(anotherGreeting)

}
