package lectures.part1basics

object CBNvsCBV extends App {

  def callByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  //this => symbol delays the evaluation of the expression passed as a parameter, and its used literally every time.
  //This is useful for lazy evaluation
  def callByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())
}
