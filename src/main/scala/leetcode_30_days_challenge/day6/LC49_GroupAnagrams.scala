package leetcode_30_days_challenge.day6

object LC49_GroupAnagrams {

  //    Given an array of strings, group anagrams together.
  //
  //            Example:
  //
  //    Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
  //    Output:
  //            [
  //            ["ate","eat","tea"],
  //            ["nat","tan"],
  //            ["bat"]
  //            ]
  //    Note:
  //
  //    All inputs will be in lowercase.
  //    The order of your output does not matter.
  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    strs.groupBy(_.toSeq.sorted.unwrap).values.map(_.toList).toList
  }
}
