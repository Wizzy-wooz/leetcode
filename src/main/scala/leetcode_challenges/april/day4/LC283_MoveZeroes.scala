package leetcode_challenges.april.day4

object LC283_MoveZeroes {
  //  Given an array nums, write a function to move all 0's to the end of it while maintaining
  // the relative order of the non-zero elements.
  //
  //  Example:
  //
  //    Input: [0,1,0,3,12]
  //  Output: [1,3,12,0,0]
  def moveZeroes(nums: Array[Int]): Unit = {
    var j = 0
    for (i <- nums.indices) {
      j = nums.indexWhere(_ != 0, j)
      if (j < 0) {
        for (k <- i until nums.length) nums(k) = 0
        return
      }
      nums(i) = nums(j)
      j += 1
    }
  }
}
