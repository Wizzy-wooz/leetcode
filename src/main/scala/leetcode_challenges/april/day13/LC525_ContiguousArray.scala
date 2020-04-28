package leetcode_challenges.april.day13

import scala.collection.mutable

object LC525_ContiguousArray {
  //    Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
  //
  //    Example 1:
  //    Input: [0,1]
  //    Output: 2
  //    Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
  //    Example 2:
  //    Input: [0,1,0]
  //    Output: 2
  //    Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
  //    Note: The length of the given binary array will not exceed 50,000.
  def findMaxLength(nums: Array[Int]): Int = {
    var map: scala.collection.mutable.HashMap[Int, Int] = new mutable.HashMap()
    map.put(0, -1)
    var  maxlen:Int = 0
    var  count:Int = 0

    for (i <- nums){
      if(nums(i) == 1) {count = count + 1} else {count = count + (-1)}
      if (map.isDefinedAt(count)) {
        maxlen = Math.max(maxlen, i - map(count))
      } else {
        map.put(count, i)
      }
    }
    maxlen
  }
}