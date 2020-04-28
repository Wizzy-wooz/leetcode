package leetcode_challenges.april.day1

object LC136_SingleNumber {
  def singleNumber(nums: Array[Int]): Int = {
    //Given a non-empty array of integers, every element appears twice except for one. Find that single one.
    //Example 1: Input: [2,2,1] Output: 1 Example 2: Input: [4,1,2,1,2] Output: 4
    nums.groupBy(identity).find(_._2.length == 1).fold(-1)(_._1)
  }
}
