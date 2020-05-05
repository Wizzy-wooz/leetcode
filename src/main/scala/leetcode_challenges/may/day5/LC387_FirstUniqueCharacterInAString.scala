package leetcode_challenges.may.day5

object LC387_FirstUniqueCharacterInAString {
  //    Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
  //
  //    Examples:
  //
  //    s = "leetcode"
  //            return 0.
  //
  //    s = "loveleetcode",
  //            return 2.
  //    Note: You may assume the string contain only lowercase letters.
  def firstUniqChar(s: String): Int = {
    val distincts = s.zipWithIndex.groupBy(_._1).filter(_._2.size == 1).mapValues(_.minBy(_._2)).values
    if (distincts.nonEmpty) distincts.minBy(_._2)._2 else -1
  }
}
