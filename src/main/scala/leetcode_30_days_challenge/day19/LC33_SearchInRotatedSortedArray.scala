package leetcode_30_days_challenge.day19

object LC33_SearchInRotatedSortedArray {
  //  Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
  //
  //  (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
  //
  //  You are given a target value to search. If found in the array return its index, otherwise return -1.
  //
  //  You may assume no duplicate exists in the array.
  //
  //    Your algorithm's runtime complexity must be in the order of O(log n).
  //
  //    Example 1:
  //
  //  Input: nums = [4,5,6,7,0,1,2], target = 0
  //  Output: 4
  //  Example 2:
  //
  //  Input: nums = [4,5,6,7,0,1,2], target = 3
  //  Output: -1
  def search(nums: Array[Int], target: Int): Int = {
    if (nums.isEmpty) -1 else search(nums, target, 0, nums.length - 1)
  }

  def search(nums: Array[Int], target: Int, l: Int, r: Int): Int = {
    if (l > r) -1 else {
      val m = (l + r) / 2
      if (nums(m) == target) m else if (nums(l) <= nums(m) && include(target, nums(l), nums(m)) ||
        nums(m) <= nums(r) && !include(target, nums(m), nums(r))
      ) {
        search(nums, target, l, m - 1)
      } else search(nums, target, m + 1, r)
    }
  }

  def include(target: Int, l: Int, r: Int): Boolean = l <= target && target <= r
}
