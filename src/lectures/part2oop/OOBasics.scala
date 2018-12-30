package lectures.part2oop

object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.age)
  println(person.x)

  person.greet("Daniel")
  person.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)
  println(novel.authorAge)
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposter))


  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print
}

class Person(name:String, val age: Int = 0) { // constructor
  // body
  val x = 2

  println(1 + 3)

  // method
  def greet(name: String): Unit = println(s"${this.name} syas: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am $name")
  //  def greet(): Int = 42

  // multiple constructors
//  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}

/*
  Novel and a Writer

  Writer: first name, surnname, year
    - method fullname

  Novel: name, year of release, author
    - authorAge
    - isWittenBy(author)
    - copy(new year of release) = new instance of Novel
 */

class Writer(val firstName: String, val surnname: String, val year: Int) {
  def fullname: String = s"$surnname $firstName"
}

class Novel(val name: String, val yearOfRelease: Int, val author: Writer) {
  def authorAge = yearOfRelease - author.year
  def isWrittenBy(author: Writer) = this.author == author
  def copy(newYearOfRelease: Int) = new Novel(name, newYearOfRelease, author)
}

/*
  Counter class
    - receives an int value
    - method current count
    - method to increment/decrement => new Counter
    - overload inc/dec to receive an amount => new Counter
 */

class Counter(val count: Int = 0) {
  def inc = {
    println("incrementing")
    new Counter(count + 1)
  } // immutability

  def dec = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n-1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    new Counter(n-1)
  }

  def print(): Unit = println(count)
}


// class parameters are not fields