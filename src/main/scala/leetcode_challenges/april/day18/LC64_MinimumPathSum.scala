package leetcode_challenges.april.day18

object LC64_MinimumPathSum {
  //  Given a m x n grid filled with non-negative numbers, find a path from top left to
  //  bottom right which minimizes the sum of all numbers along its path.
  //
  //    Note: You can only move either down or right at any point in time.
  //
  //  Example:
  //
  //  Input:
  //  [
  //  [1,3,1],
  //  [1,5,1],
  //  [4,2,1]
  //  ]
  //  Output: 7
  //  Explanation: Because the path 1→3→1→1→1 minimizes the sum.
  import scala.collection.mutable

  def minPathSum(grid: Array[Array[Int]]): Int = {
    val solutions: mutable.Map[(Int, Int), Int] = mutable.Map[(Int, Int), Int]()

    def navigate(row: Int, column: Int): Int = {
      solutions.getOrElse((row, column), {
        solutions((row, column)) = {
          val rightCosts: Option[Int] = if (column + 1 < grid(row).length) Some(navigate(row, column + 1)) else None
          val downCosts: Option[Int] = if (row + 1 < grid.length) Some(navigate(row + 1, column)) else None

          (rightCosts, downCosts) match {
            case (None, None) => grid(row)(column) //we are at the bottom right corner
            case (Some(rightCosts), None) => grid(row)(column) + rightCosts
            case (None, Some(leftCosts)) => grid(row)(column) + leftCosts
            case (Some(rightCosts), Some(downCosts)) => grid(row)(column) + Math.min(rightCosts, downCosts)
          }
        }
        solutions((row, column))
      })
    }

    navigate(0, 0)
  }
}
