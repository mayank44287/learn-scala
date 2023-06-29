package lectures.part2fp

import scala.annotation.tailrec

object TupleAndMaps extends App {

  //Tuples
  val aTuple = new Tuple2(2, "Hello World!") // syntax sugar Tuple2[Int,String] = (Int, String)
  val anotherTuple = Tuple2(3, "Mayank Raj")
  val oneMoreTuple = (4, "mayank")
  // all three definitions are equivalent
  // tuples can group at most 22 elements of diff types


  //maps
  val aMap: Map[String, Int] = Map()
  val phonebook1 = Map(("Jim",1234), "Daniel" -> 4321)
  // a-> b syntax sugar for (a,b)
  //withDefaultValue will not throw exception if no key found error
  val phonebook = Map(("Jim",1234), "Daniel" -> 4321).withDefaultValue(-1)

  println(phonebook)

  //map operations
  println(phonebook.contains("Jim"))
  println(phonebook("Mayank"))  //gets the value for the key

  //functionals on map
  //map, filter, flatmap
  println(phonebook.map(pair => pair._1.toLowerCase() -> pair._2))

  //filterkeys
  println(phonebook.view.filterKeys(x => x.startsWith("J")).toMap)

  //mapvalues
  println(phonebook.view.mapValues(number=> "1111" + number).toMap)


  // conversions to other collections
  println(phonebook.toList)
  //  println(List(("Daniel", 555)).toMap)
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  //println(names.groupBy(name => name.charAt(0)))
  //println(names.groupBy(name => name.charAt(0) == 'J'))

  /*
      1.  What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 900

          !!! careful with mapping keys.

      2.  Overly simplified social network based on maps
          Person = String
          - add a person to the network
          - remove
          - friend (mutual)
          - unfriend

          - number of friends of a person
          - person with most friends
          - how many people have NO friends
          - if there is a social connection between two people (direct or not)
     */

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    network + (person -> Set())
  }

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAccuumulator: Map[String, Set[String]]): Map[String, Set[String]] = {
      if (friends.isEmpty) networkAccuumulator
      else removeAux(friends.tail, unfriend(networkAccuumulator, person, friends.head))
      //call unfriend for head and the person, then recursively call remove aux with remaining of the friends
    }
    val unfriended = removeAux(network(person), network)
    unfriended - person
  }


  val empty : Map[String, Set[String]] = Map()
  val network = add(add(empty, "Mary"), "Bob")
  println(network)

  println(friend(network,"Bob", "Mary"))

  println(unfriend(friend(network,"Bob", "Mary"), "Bob", "Mary"))
  println(remove(friend(network,"Bob", "Mary"),"Bob"))

  // Jim,Bob,Mary
  val people = add(add(add(empty, "Bob"), "Mary"), "Jim")
  val jimBob = friend(people, "Bob", "Jim")
  val testNet = friend(jimBob, "Bob", "Mary")

  println(testNet)

  def nFriends(network: Map[String, Set[String]], person: String): Int =
    if (!network.contains(person)) 0
    else network(person).size

  println(nFriends(testNet, "Bob"))

  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  println(mostFriends(testNet))

  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int =
    network.count(_._2.isEmpty)

  println(nPeopleWithNoFriends(testNet))

  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
    @tailrec
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if (discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if (person == target) true
        else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
      }
    }

    bfs(b, Set(), network(a) + a)
  }

  println(socialConnection(testNet, "Mary", "Jim"))
  println(socialConnection(network, "Mary", "Bob"))

}
