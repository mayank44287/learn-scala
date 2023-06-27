package lectures.part1basics

object Functions extends App{

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 8))

  //Parameterless functions can be called without using the parenthesis
  def aParameterLessFunction: Int = 42

  println(aParameterLessFunction)

  def aRepeatedFunction(aString: String, n: Int): String ={
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("hello",3))

  //WHEN YOU NEED LOOPS, USE RECURSION
  //Compiler cannot infer return type for recursive functions in scala


  //Exercices
  /*
    1. A greeting function (name, age)=> "Hi, my name is $name and $years age.
    2. A factorial function
    3. A fibonacci function
    4. IsPrime
  */

  def aGreeting(aName: String, age: Int): String ={
    "My name is " + aName + " and I am " +  age + "years old"
  }

  def factorial(n: Int) : Int= {
    if (n <= 0) 1
    else n*factorial(n-1)
  }

  def fibonacci(n: Int): Int = {
  if (n <= 2) 1
  else fibonacci(n-1) + fibonacci(n-2)
  }

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else (n % t) != 0 && isPrimeUntil(t-1)
    }
    isPrimeUntil(n/2)
  }

  println(aGreeting("Mayank",31))
  println(factorial(5))
  println(fibonacci(8))
  println(isPrime(51))
}
