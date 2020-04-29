package dp

object LC213_HouseRobberII {
  //  You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
  //
  //  Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
  //
  //  Example 1:
  //
  //  Input: [2,3,2]
  //  Output: 3
  //  Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
  //  because they are adjacent houses.
  //    Example 2:
  //
  //  Input: [1,2,3,1]
  //  Output: 4
  //  Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
  //    Total amount you can rob = 1 + 3 = 4.
  def rob(nums: Array[Int]): Int = nums
    .headOption
    .map(h => dp(nums, 1, nums.length) max (h + dp(nums, 2, nums.length - 1)))
    .getOrElse(0)

  private def dp(nums: Array[Int], i1: Int, i2: Int) = ((0, 0) /: nums.slice(i1, i2)) {
    (d, n) => ((n + d._2) max d._1, d._1)
  }._1
}
