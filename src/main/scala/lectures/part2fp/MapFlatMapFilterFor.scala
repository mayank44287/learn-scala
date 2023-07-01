package lectures.part2fp

object MapFlatMapFilterFor extends App {

  val list = List(1,2,3)

  println(list)

  //map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  //filter
  println(list.filter(x => x%2==0))

  //flatmap
  val toPair =  (x: Int) => List(x, x+1)
  println(list.flatMap(toPair))


  //print all combinations betweem two lists
  val numbers = List(1,2,3)
  val chars = List("a","b","c","d")
  val colors = List("black","white")

  //iterations
  val combinations = numbers.flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-" + color )))
  //println(combinations)

  //foreach
  list.foreach(println)

  //for comprehensions
  val forCombination = for {
    n <- numbers
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color
  println(forCombination)

    //syntax overload
    list.map { x =>
      x*2
    }

  /*
      1.  MyList supports for comprehensions?
          map(f: A => B) => MyList[B]
          filter(p: A => Boolean) => MyList[A]
          flatMap(f: A => MyList[B]) => MyList[B]
      2.  A small collection of at most ONE element - Maybe[+T]
          - map, flatMap, filter
      solution in Maybe.scala under exercise for 2
     */

}
