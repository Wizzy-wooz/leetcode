package leetcode_challenges.april.day23

object LC201_BitwiseANDOfNumbersRange {
  //    Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
  //
  //            Example 1:
  //
  //    Input: [5,7]
  //    Output: 4
  //    Example 2:
  //
  //    Input: [0,1]
  //    Output: 0
  def rangeBitwiseAnd(m: Int, n: Int): Int = {
    def bitFunc(a: Int, b: Int, mask: Int): Int = {
      if ((a & mask) == (b & mask)) {
        a & mask
      } else {
        bitFunc(a, b, mask << 1)
      }
    }
    bitFunc(m, n, 0xffffffff)
  }
}
