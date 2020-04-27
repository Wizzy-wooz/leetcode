package leetcode_30_days_challenge.day26

object LC1143_LongestCommonSubsequence {
//  Given two strings text1 and text2, return the length of their longest common subsequence.
//
//    A subsequence of a string is a new string generated from the original string with some characters(can be none)
  // deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde"
  // while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
//
//
//
//    If there is no common subsequence, return 0.
//
//
//
//  Example 1:
//
//  Input: text1 = "abcde", text2 = "ace"
//  Output: 3
//  Explanation: The longest common subsequence is "ace" and its length is 3.
//  Example 2:
//
//  Input: text1 = "abc", text2 = "abc"
//  Output: 3
//  Explanation: The longest common subsequence is "abc" and its length is 3.
//  Example 3:
//
//  Input: text1 = "abc", text2 = "def"
//  Output: 0
//  Explanation: There is no such common subsequence, so the result is 0.
  /**
    * Find longest common subsequence using Dynamic Programming
    */
  def longestCommonSubsequence(s1: String, s2: String): Int = {
    val m = s1.length
    val n = s2.length
    var table = Array.ofDim[Int](m, n)
    var tmp = 0
    for (i <- 0 until m) {
      if (s1.charAt(i) == s2.charAt(0)) tmp = 1
      table(i)(0) = tmp
    }
    tmp = 0
    for (i <- 0 until n) {
      if (s1.charAt(0) == s2.charAt(i)) tmp = 1
      table(0)(i) = tmp
    }

    for {i <- 1 until m
         j <- 1 until n}
      table(i)(j) = if (s1.charAt(i) == s2.charAt(j)) table(i - 1)(j - 1) + 1 else Math.max(table(i - 1)(j), table(i)(j - 1))

    table(m - 1)(n - 1)
  }
}
