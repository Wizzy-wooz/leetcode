package leetcode_challenges.april.day16

object LC678_ValidParenthesisString {
  //    Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
  //
  //    Any left parenthesis '(' must have a corresponding right parenthesis ')'.
  //    Any right parenthesis ')' must have a corresponding left parenthesis '('.
  //    Left parenthesis '(' must go before the corresponding right parenthesis ')'.
  //            '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
  //    An empty string is also valid.
  //    Example 1:
  //    Input: "()"
  //    Output: True
  //    Example 2:
  //    Input: "(*)"
  //    Output: True
  //    Example 3:
  //    Input: "(*))"
  //    Output: True
  //    Note:
  //    The string size will be in the range [1, 100].

  def checkValidString(s: String): Boolean = {
    val xs = s.scanLeft((0, 0)){
      case ((low, high), '(') => (low + 1, high + 1)
      case ((low, high), ')') => (Math.max(0, low - 1), high - 1)
      case ((low, high), '*') => (Math.max(0, low - 1), high + 1)
      case (_, _) => throw new IllegalArgumentException("Invalid input.")
    }
    !xs.exists(_._2 < 0) && xs.last._1 == 0
  }
}
