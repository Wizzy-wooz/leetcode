package leetcode_30_days_challenge.day17

import scala.annotation.tailrec
import scala.collection.mutable

object LC200_NumberOfIslands {
//  Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
  // An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
  // You may assume all four edges of the grid are all surrounded by water.
//
//  Example 1:
//
//  Input:
//    11110
//  11010
//  11000
//  00000
//
//  Output: 1
//  Example 2:
//
//  Input:
//    11000
//  11000
//  00100
//  00011
//
//  Output: 3
  def numIslands(grid: Array[Array[Char]]): Int = {
    val is = mutable.Set[(Int, Int)]()
    var n = 0
    val row = grid.length
    if (row == 0) return 0
    val col = grid(0).length
    if (col == 0) return 0
    val islandQueue = mutable.Queue[(Int, Int)]()

    def judgeAndAdd(x: Int, y: Int): Unit = {
      if (x >= 0 && y >= 0 && x <= row - 1 && y <= col - 1 && grid(x)(y) == '1' && !is(
        x,
        y)) {
        islandQueue.enqueue((x, y))
        is.add(x, y)
      }
    }

    @tailrec
    def fillIsland(x: Int, y: Int): Unit = {
      judgeAndAdd(x, y)
      judgeAndAdd(x - 1, y)
      judgeAndAdd(x + 1, y)
      judgeAndAdd(x, y + 1)
      judgeAndAdd(x, y - 1)
      islandQueue.dequeue()
      if (islandQueue.nonEmpty) {
        fillIsland(islandQueue.head._1, islandQueue.head._2)
      }
    }

    for (i <- grid.indices) {
      for (j <- grid(i).indices) {
        //now ,we have found a island which hasn't been discovered
        if (grid(i)(j) == '1' && !is(i, j)) {
          n += 1
          //and we will do BFS to fill all coordinates of the island into is
          fillIsland(i, j)
        }
      }
    }
    n
  }

  numIslands(
    Array(Array('1', '1', '1'), Array('0', '1', '0'), Array('1', '1', '1')))
}
