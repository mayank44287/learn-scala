package lectures.part1basics

import scala.annotation.tailrec
import scala.jdk.Accumulator

object Recursion extends App {

  // The usual factorial function
  def factorial(n: Int) : Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " I first need factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n);

      result;
    }
   }

  def anotherFactorial(n: Int) : BigInt= {
    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factHelper(x-1, x*accumulator)
    }
    factHelper(n,1)
  }

  //this process is basically tail recursion, which we can specify on top of the method as @tailrec, to tell compiler that
  //its a tail recursive method.
  /*
    anotherFactorial(10) = factHelper(10,1)
    = factHelper(9,10*!)
    = factHelper(8, 9*10*1)
    = factHelper(7, 8*9*10*1)
    = ....
    = factHelper(2, 3*4*5*...9*10*1)
    = factHelper(1, 2*3*4*5*6*7*8*9*1)
    = 1*2*3*4*5*6*7*8*9*10
  */


  //println(anotherFactorial(5))

  //WHEN YOU NEED LOOPS, USE TAIL_RECURSION

  /*
  * 1. CONCATENATE A STRING N TIMES
  * 2. ISPRIME THROUGH TAIL RECURSION
  * 3. FIBONACCI THROUGH TAIL RECURSION
  *  */

  @tailrec
  def concatenateNTimesTailRec(aString: String, n: Int, accumulator: String): String= {
    if (n <= 0) accumulator
    else concatenateNTimesTailRec(aString, n-1, aString + accumulator )
  }

  def isPrime(n: Int ): Boolean= {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean ): Boolean = {
      if (!isStillPrime)  false
      else if (t <= 1) true
      else isPrimeTailRec(t-1, n % t != 0 && isStillPrime)
    }
    isPrimeTailRec(n/2, true)
  }
  //Another implementation for tailrecursive isPrime
  def isPrime1(n: Int): Boolean = {
    @tailrec
    def isPrimeInner(divisor: Int): Boolean = {

      if (divisor <= 1) true
      else if (n % divisor == 0) false
      else isPrimeInner(divisor - 1)
    }

    isPrimeInner(n / 2)
  }


  def fibonacci(n: Int): Int = {
    def fibonacciTaiRec(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else fibonacciTaiRec(i+1, last + nextToLast, last)
    }
    if (n <= 2) 1
    else fibonacciTaiRec(2,1,1)
  }
  println(concatenateNTimesTailRec("mayank", 3,""))
  println(isPrime1(15))
  println(fibonacci(8))
}

