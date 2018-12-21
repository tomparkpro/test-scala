package lectures.part1basics

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)
      result
    }

//  println(factorial(5000))

  def anotherFactorial(n: BigInt): BigInt = {
    def factHelper(x: BigInt, accmulator: BigInt): BigInt =
      if (x <= 1) accmulator
      else factHelper(x-1, x * accmulator)

    factHelper(n, 1)
  }

  /*
    anotherFactorial(10) = factHelper(10, 1)
    = factHelper(9, 10 * 1)
    = factHelper(8, 9 * 10, 1)
    = ..
    = factHelper(2 * 3 * 4 ... 9 * 10 * 1)
    = fac tHelper(1 * 2 * 3 * 4 ... 9 * 10)
        = 1 * 2 * 3 * 4 ... 9 * 10
   */

  println(anotherFactorial(20000))
}
