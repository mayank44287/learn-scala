package lectures.part2oop

object OOBasics extends App{

  val person = new Person("Mayank", 31)
//  println(person)
  person.greet("Daniel")
  person.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)
//  println(novel.authorAge)
//  println(novel.isWrittenBy(author))

  val counter = new Counter
  println(counter.inc.print)
}


class Person(name: String, age: Int) {
  //body
  val x = 2;

  def greet(name:String): Unit = println(s"${this.name} says : Hi, $name")

  //overloading means defining methods with same names but different signatures
  def greet(): Unit = println(s"Hi I am $name")

  //multiple constructors
  def this(name: String) = this(name,0)
  def this() = this("John Doe")
}

/*
* Novel and a Writer
  Writer: first name, surname, year
    - method fullname
  Novel: name, year of release, author
  - authorAge
  - isWrittenBy(author)
  - copy (new year of release) = new instance of Novel
*
*
* */

class Writer(fName: String, surname: String, val year: Int) {

  def fullName : String = fName + " " + surname;
}

class Novel(name: String, yearRelease: Int, author: Writer) {

  def authorAge : Int = yearRelease - author.year

  def isWrittenBy(author: Writer) = author == this.author

  def copy(newYear: Int): Novel = new Novel(name, newYear, author)


}
/*
  Counter class
    - receives an int value
    - method current count
    - method to increment/decrement => new Counter
    - overload inc/dec to receive an amount
 */

class Counter(val count: Int = 0)  {
  def inc = {
    println("incrementing")
    new Counter(count + 1)    //immutability
  }

  def dec = {
    println("Decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int) : Counter = {
    if (n <= 0) this
    else inc.inc(n-1)
  }

  def dec(n: Int) : Counter = {
    if (n <= 0) this
    else dec.dec(n-1)
  }

  def print = println(count)
}