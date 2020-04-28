package dp

import scala.annotation.tailrec


object LC5_LongestPalindromicSubstring {
  //  Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
  //
  //  Example 1:
  //
  //  Input: "babad"
  //  Output: "bab"
  //  Note: "aba" is also a valid answer.
  //  Example 2:
  //
  //  Input: "cbbd"
  //  Output: "bb"
  def longestPalindrome(s: String): String = {

    @tailrec
    def maxAt(startIndex: Int, endIndex: Int): String = {
      if (startIndex < 0 || endIndex > s.length - 1 || s.charAt(startIndex) != s.charAt(endIndex))
        s.substring(startIndex + 1, endIndex)
      else
        maxAt(startIndex - 1, endIndex + 1)
    }

    @tailrec
    def lp(st: Int, largestYet: String): String = {
      if (st == s.length) largestYet
      else {
        val largestOdd = maxAt(st - 1, st + 1)
        val largestEven = maxAt(st, st + 1)

        if (largestOdd.length > largestEven.length && largestOdd.length > largestYet.length)
          lp(st + 1, largestOdd)
        else if (largestEven.length > largestOdd.length && largestEven.length > largestYet.length)
          lp(st + 1, largestEven)
        else
          lp(st + 1, largestYet)
      }
    }

    lp(0, "")
  }
}
