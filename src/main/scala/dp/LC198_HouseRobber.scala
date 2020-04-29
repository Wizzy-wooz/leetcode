package dp

object LC198_HouseRobber {
  /**
    * You are a professional robber planning to rob houses along a street. Each
    * house has a certain amount of money stashed, the only constraint stopping
    * you from robbing each of them is that adjacent houses have security system
    * connected and it will automatically contact the police if two adjacent houses
    * were broken into on the same night.
    *
    * Given a list of non-negative integers representing the amount of money of
    * each house, determine the maximum amount of money you can rob tonight without
    * alerting the police.
    *
    */
  def rob(nums: Array[Int]): Int = {
    import collection.mutable.Map
    val len = nums.length
    val memo: Map[Int, Int] = Map().withDefaultValue(-1)

    def helper(start: Int): Int = {
      if(start >= len) return 0
      if(len - start == 1) return nums(start)
      if(len - start == 2) return Math.max(nums(start), nums(start + 1))
      if(memo(start) != -1) {
        return memo(start)
      }
      val result = Math.max(nums(start) + helper(start + 2), nums(start + 1) + helper(start + 3))
      memo(start) = result
      result
    }
    Math.max(helper(0), helper(1))
  }
}
