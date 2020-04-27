package leetcode_30_days_challenge.day3

object LC53_MaximumSubarray {
//  Given an integer array nums, find the contiguous subarray (containing at least one number)
  // which has the largest sum and return its sum.
//
//  Example:
//
//    Input: [-2,1,-3,4,-1,2,1,-5,4],
//  Output: 6
//  Explanation: [4,-1,2,1] has the largest sum = 6.
  def maxSubArray(nums: Array[Int]): Int = {
    nums.tail.scan(nums.head){(s,e) => math.max(s+e, e)}.max
  }
}
