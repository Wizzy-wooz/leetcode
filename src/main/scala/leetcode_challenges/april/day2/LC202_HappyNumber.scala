package leetcode_challenges.april.day2

object LC202_HappyNumber {
//  Write an algorithm to determine if a number n is "happy".
//
//    A happy number is a number defined by the following process: Starting with any positive integer,
  // replace the number by the sum of the squares of its digits,
  // and repeat the process until the number equals 1 (where it will stay),
  // or it loops endlessly in a cycle which does not include 1.
  // Those numbers for which this process ends in 1 are happy numbers.
//
//    Return True if n is a happy number, and False if not.
//
//    Example:
//
//    Input: 19
//  Output: true
//  Explanation:
//    12 + 92 = 82
//  82 + 22 = 68
//  62 + 82 = 100
//  12 + 02 + 02 = 1

  import scala.collection.immutable.HashSet
  def isHappy(n: Int): Boolean = {
    def isHappy(n: Int, previousNumbers: HashSet[Int]): Boolean = {
      if (previousNumbers.contains(n)) false
      else {
        val sum: Int = n.toString.map(c => (c - '0') * (c - '0')).sum
        if (sum == 1) true
        else isHappy(sum, previousNumbers + n)
      }
    }

    isHappy(n, HashSet.empty[Int])
  }
}
