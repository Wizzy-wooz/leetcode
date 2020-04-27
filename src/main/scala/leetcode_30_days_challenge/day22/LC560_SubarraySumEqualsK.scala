package leetcode_30_days_challenge.day22

object LC560_SubarraySumEqualsK {

  //    Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
  //
  //            Example 1:
  //    Input:nums = [1,1,1], k = 2
  //    Output: 2
  //    Note:
  //    The length of the array is in range [1, 20,000].
  //    The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
  case class Carry(count: Int, sum: Int, map: Map[Int, Int])

  def subarraySum(nums: Array[Int], k: Int): Int = {
    val carryFunc = addToCarry(k) _
    val first = Carry(0, 0, Map(0 -> 1).withDefaultValue(0))
    nums.foldLeft(first)(carryFunc).count
  }

  def addToCarry(k: Int)(carry: Carry, value: Int): Carry = {
    val acc = carry.sum + value
    val newMap = carry.map + (acc -> (carry.map(acc) + 1))
    if (carry.map.contains(acc - k)) {
      Carry(carry.count + carry.map(acc - k), acc, newMap)
    } else {
      Carry(carry.count, acc, newMap)
    }
  }
}
