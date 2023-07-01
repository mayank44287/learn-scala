package lectures.part1basics

object ValuesVariablesTypes extends App{

  //vals are immutable, compiler can infer types, even if we leave out the type
  val x: Int = 32
  println(x)

  //variables are mutable, they are also called side effects of functional programming
  var aVariable:Int = 43

}
