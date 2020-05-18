package leetcode_challenges.may.day17

object LC438_FindAllAnagramsInAString {
  //  Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
  //
  //    Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
  //
  //  The order of output does not matter.
  //
  //    Example 1:
  //
  //  Input:
  //    s: "cbaebabacd" p: "abc"
  //
  //  Output:
  //  [0, 6]
  //
  //  Explanation:
  //    The substring with start index = 0 is "cba", which is an anagram of "abc".
  //  The substring with start index = 6 is "bac", which is an anagram of "abc".
  //  Example 2:
  //
  //  Input:
  //    s: "abab" p: "ab"
  //
  //  Output:
  //  [0, 1, 2]
  //
  //  Explanation:
  //    The substring with start index = 0 is "ab", which is an anagram of "ab".
  //  The substring with start index = 1 is "ba", which is an anagram of "ab".
  //  The substring with start index = 2 is "ab", which is an anagram of "ab".
  def findAnagrams(s: String, p: String): List[Int] = solver(s, p.sorted, 0, List[Int]())

  def solver(s: String, p: String, i: Int, acc: List[Int]): List[Int] = s match {
    case "" => acc
    case y: String if y.length < p.length => acc
    case y: String if y.substring(0, p.length).sorted == p => solver(s.tail, p, i + 1, i :: acc)
    case _ => solver(s.tail, p, i + 1, acc)
  }
}
