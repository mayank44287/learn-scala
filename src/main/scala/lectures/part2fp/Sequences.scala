package lectures.part2fp

import scala.collection.View.Collect
import scala.util.Random

object Sequences extends App{
  //Seq

  val aSequence = Seq(1,3,4,2)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(5,6,7))
  println(aSequence.sorted)


  //Ranges
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  (1 to 10).foreach(x => println("hello"))

  //Lists
  val aList = List(1,2,3,4)
  val prepended = 42 :: aList
  val prepend = 43 +: aList
  val append = aList :+ 44
  //println(append)

  val apple5 = List.fill(5)("Apple")
  //println(apple5)

  //println(aList.mkString("!?"))

  //Arrays
  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[String](3)

  threeElements.foreach(println)

  //mutation
  numbers(2) = 5      //syntax sugar for nummbers.update(2,5)
  println(numbers.mkString(" "))

  //arrays and seq
  val numberSeq: Seq[Int] = numbers     //implicit conversion
  println(numberSeq)


  //Vectors
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  //vectors vs lists

  val maxRuns = 1000
  val maxCapacity = 1000000

  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt()) // updated -> (index to be updated, new updated value
      System.nanoTime() - currentTime
    }
    (times.sum * 1.0 )/maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  //runtime for list ~= 5 times that for vector
  println(getWriteTime(numbersList))
  println(getWriteTime(numbersVector))




}
