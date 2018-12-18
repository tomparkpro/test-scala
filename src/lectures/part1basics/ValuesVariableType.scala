package lectures.part1basics

object ValuesVariableType extends App {

  //val x: Int = 42
  //val y: Int = "hello, Scala"
  val x = 42
  println(x)

  //x = 2
  // VALS are immutable

  // Compiler can infer type

  val aString: String = "hello"
  val anotherString = "goodbye"

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val aInt: Int = x
  val aShort: Short = 12342
  val aLong: Long = 23123213L
  val aFloat: Float = 2.9f
  val aDouble: Double = 3.14

  // variables
  var aVariable: Int = 4
  aVariable = 5 // side effects

}
