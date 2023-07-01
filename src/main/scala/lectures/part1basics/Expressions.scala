package lectures.part1basics

object Expressions extends App {

  val x = 1+2;  //expressions
  println(x)

  //Instructions (Do) vs Expression (Value)

  //IF expression
  val aCondition = true;
  val aConditionValue = if (aCondition) 5 else 3;
  println(aConditionValue)
  println(if(aCondition) 5 else 3)
  println(1+3)

  var i = 0
  val aWhile = while (i < 10){
    println(i)
    i += 1
  }

  //Never write this type of while loop in scala, this is imperative style and not functional type  coding

  //Code Blocks
   val aCodeBlock = {
     val y = 2
     val z = 5
     if (z > 2) "hello" else "bye"
   }
  println(aCodeBlock)

  //1. What is the diff bw "hello" vs println("hello)

  val someValue = {
    2 < 3
  }

  val someOtherValue = {
    if (someValue) 239 else 986
  }

}
