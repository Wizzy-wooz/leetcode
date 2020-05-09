package leetcode_challenges.may.day9

object LC367_ValidPerfectSquare {
  //  Given a positive integer num, write a function which returns True if num is a perfect square else False.
  //
  //    Note: Do not use any built-in library function such as sqrt.
  //
  //  Example 1:
  //
  //  Input: 16
  //  Output: true
  //  Example 2:
  //
  //  Input: 14
  //  Output: false
  def isPerfectSquare(num: Int): Boolean = {
    var temp:Double = scala.math.sqrt(num)
    var tempInt:Int = temp.toInt
    var res = false
    if(temp == tempInt) res = true
    else res = false
    res
  }
}
