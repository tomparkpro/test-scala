package lectures.part1basics

import scala.annotation.tailrec

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

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accmulator: BigInt): BigInt =
      if (x <= 1) accmulator
      else factHelper(x-1, x * accmulator) // TAIL RECURSION = use recursive call as the LAST expression

    factHelper(n, 1)
  }

  /*
    anotherFactorial(10) = factHelper(10, 1)
    = factHelper(9, 10 * 1)
    = factHelper(8, 9 * 10, 1)
    = ..
    = factHelper(2 * 3 * 4 ... 9 * 10 * 1)
    = factHelper(1, 1 * 2 * 3 * 4 ... 9 * 10)
    = 1 * 2 * 3 * 4 ... 9 * 10
   */

  // when you need loops, use tail recursion

  println(anotherFactorial(20000))

  /*
    1. Concatenate a string n times
    2. IsPrime function tail recursive
    3. Finobacci function tail recursive
   */

  @tailrec
  def concatenateTailrec(aString: String, n: Int, accumulator: String): String = {
    if (n < 1) accumulator
    else concatenateTailrec(aString, n-1, aString + accumulator)
  }

  println(concatenateTailrec("tom", 3, ""))


  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t-1, n%t != 0 && isStillPrime)
    }

    if (n == 1) false
    else isPrimeTailrec(n/2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))
  println(isPrime(1))
  println(isPrime(2))

  def finonacci(n: Int): Int = {
    @tailrec
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else fiboTailrec(i + 1, last + nextToLast, last)
    }

    if (n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }

  println(finonacci(8)) // 1 1 2 3 5 8 13 21
}
