package leetcode_challenges.may.day11

class LC733_FloodFill {
//  An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
//
//  Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
//
//    To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
//
//  At the end, return the modified image.
//
//    Example 1:
//  Input:
//    image = [[1,1,1],[1,1,0],[1,0,1]]
//  sr = 1, sc = 1, newColor = 2
//  Output: [[2,2,2],[2,2,0],[2,0,1]]
//  Explanation:
//    From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
//  by a path of the same color as the starting pixel are colored with the new color.
//    Note the bottom corner is not colored 2, because it is not 4-directionally connected
//    to the starting pixel.
def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = {
  val (n_rows, n_cols) = (image.length, image(0).length)
  val oldColor = image(sr)(sc)

  def fill(row: Int, col: Int): Unit = {
    if (row >= 0 && row < n_rows && col >= 0 && col < n_cols && image(row)(col) == oldColor) {
      image(row)(col) = newColor
      fill(row - 1, col)
      fill(row, col - 1)
      fill(row + 1, col)
      fill(row, col + 1)
    }
  }

  if (oldColor != newColor) {
    fill(sr, sc)
  }
  image
}
}
