package leetcode_challenges.may.day8

object LC1232_CheckIfItIsAStraightLine {
  //    You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
  //    Check if these points make a straight line in the XY plane.
  //    Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
  //    Output: true
  //    Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
  //    Output: false
  def checkStraightLine(coordinates: Array[Array[Int]]): Boolean = {
    val slope = (coordinates(1)(1) - coordinates(0)(1)).toDouble / (coordinates(1)(0) - coordinates(0)(0)).toDouble
    coordinates.drop(2).dropRight(1).zip(coordinates.drop(3)).foldLeft(true) { case (b, (p1, p2)) =>
      b && slope == (p2(1) - p1(1)).toDouble / (p2(0) - p1(0)).toDouble
    }
  }
}
