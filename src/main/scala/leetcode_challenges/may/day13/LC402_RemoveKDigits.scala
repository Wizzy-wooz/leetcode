package leetcode_challenges.may.day13

class LC402_RemoveKDigits {
  //    Given a non-negative integer num represented as a string, remove k digits from the number
  //    so that the new number is the smallest possible.
  //
  //            Note:
  //    The length of num is less than 10002 and will be ≥ k.
  //    The given num does not contain any leading zero.
  //            Example 1:
  //
  //    Input: num = "1432219", k = 3
  //    Output: "1219"
  //    Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
  //    Example 2:
  //
  //    Input: num = "10200", k = 1
  //    Output: "200"
  //    Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
  //            Example 3:
  //
  //    Input: num = "10", k = 2
  //    Output: "0"
  //    Explanation: Remove all the digits from the number and it is left with nothing which is 0.
  def removeKdigits(num: String, k: Int): String = {
    var toRemove = k
    val result = new Array[Char](num.length)
    var i = 0
    var j = -1
    while(i < num.length) {
      if (toRemove > 0 && j >= 0 && num(i) < result(j)) {
        j -= 1
        toRemove -= 1
      } else {
        j += 1
        result(j) = num(i)
        i += 1
      }
    }
    val trimmed = result.take(num.length - k).dropWhile(_ == '0')
    if (trimmed.isEmpty) "0" else trimmed.mkString
  }
}
