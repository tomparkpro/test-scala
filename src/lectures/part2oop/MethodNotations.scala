package lectures.part2oop

object MethodNotations extends App {

  class Person(val name:String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favoriteMovie)
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def learns(subject: String): String = s"$name learns $subject"
    def learnsScala: String = this learns "Scala"
    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name I like $favoriteMovie"
    def apply(n: Int) = s"$name watched $favoriteMovie $n times"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation = operator notation (syntactic sugar)

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // all operators are methods

  // prefix notation
  val x = -1        // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_prefix only works with - + ~ !
  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) // equivalent

  println((mary + "the rockstar").apply())

  println((+mary).age)
  println(mary learnsScala)
  println(mary(10))
  /*
    1. overload the + operator
      mary + "the rockstar" => new person "Mary (the rockstar)"

    2. add an age to the Person class
       add a unary + operator => new Person with the age + 1
       +mary => mary with the age incrementer

    3. add a "learns" method in the Person class => "Mary learns Scala"
       add a learnsScala method, calls learns method with "Scala"
        use it in postfix notation.

    4. overload the apply method
       mary.apply(2) => "Mary watched Inception 2 times"
   */
}
