package leetcode_30_days_challenge.day27

object LC221_MaximalSquare {
//  Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
//
//  Example:
//
//    Input:
//
//  1 0 1 0 0
//  1 0 1 1 1
//  1 1 1 1 1
//  1 0 0 1 0
//
//  Output: 4
  def maximalSquare(matrix: Array[Array[Char]]): Int = {
    if(matrix.isEmpty || matrix(0).isEmpty) return 0
    var res = 0
    var len1 = matrix.length
    var len2 = matrix(0).length
    var dp = Array.ofDim[Int](len1,len2)
    for(i <- 0 until len1){
      for(j <- 0 until len2){
        dp(i)(j)=0
      }
    }
    for(i <- 0 until len1){
      for(j <- 0 until len2){
        if(i==0||j==0){
          dp(i)(j)= matrix(i)(j)-'0'
        }else if(matrix(i)(j)=='1'){
          dp(i)(j) = scala.math.min(dp(i-1)(j-1),scala.math.min(dp(i-1)(j),dp(i)(j-1))) +1
        }
        res = scala.math.max(dp(i)(j),res)
      }
    }
    res*res
  }
}
