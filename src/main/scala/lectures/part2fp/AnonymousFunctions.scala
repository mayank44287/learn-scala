package lectures.part2fp

object AnonymousFunctions extends App{

  //anonymous function or LAMBDA
  val doubler = (x: Int) => x * 2
  //OR
  val doubler1 : Int => Int = x => x*2

  //println(doubler(1))
  //println(doubler1(1))

  //multiple parameters in a lambda
  val adder = (x: Int, y: Int) => x+ y

  //OR
  val adder1 : (Int, Int) => Int = (x: Int, y: Int) => x + y

  //println(adder(2,3))
  //println(adder1(2,3))

  //no params
  val nustDoSomething: () => Int = () => 3

  //println(nustDoSomething)      //function itself which is an instance of some class
  //println(nustDoSomething())    //function call

  //curly braces with lambda

  val stringToInt= { (str: String) =>
    str.toInt

  }

  //more syntactical sugar

  val niceIncrementor: Int => Int = _ +1    //equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _  //equivalent to (a,b) => a + b

  /*
      1.  MyList: replace all FunctionX calls with lambdas
      2.  Rewrite the "special" adder as an anonymous function
     */

  val superAdder : (Int, Int) => Int = (a,b) => a+b

  //OR
  val superAdder1 = (x:Int, y: Int) => x+y

  println(superAdder(2,3))
  println(superAdder1(2,3))


}
