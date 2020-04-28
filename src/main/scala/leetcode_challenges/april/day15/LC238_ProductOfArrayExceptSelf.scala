package leetcode_challenges.april.day15

object LC238_ProductOfArrayExceptSelf {
  //  Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
  //
  //    Example:
  //
  //    Input:  [1,2,3,4]
  //  Output: [24,12,8,6]
  //  Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
  //
  //    Note: Please solve it without division and in O(n).
  //
  //  Follow up:
  //    Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    val length = nums.length
    if (length == 0 || length == 1) return nums
    if (length == 2) return nums.reverse

    val leftArr = Array.tabulate[Int](length)(_ => 1)
    val rightArr = Array.tabulate[Int](length)(_ => 1)
    val outputArr = Array.tabulate[Int](length)(_ => 1)

    leftArr(0) = 1
    rightArr(length - 1) = 1

    for (i <- nums.indices if i != 0) {
      leftArr(i) = nums(i - 1) * leftArr(i - 1)
    }

    for (i <- length - 2 to 0 by -1) {
      rightArr(i) = nums(i + 1) * rightArr(i + 1)
    }

    for (i <- 0 until length) {
      outputArr(i) = leftArr(i) * rightArr(i)
    }
    outputArr
  }
}
