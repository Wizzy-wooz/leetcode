package leetcode_challenges.april.day9

object LC844_BackspaceStringCompare {
//  Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
//
//  Note that after backspacing an empty text, the text will continue empty.
//
//    Example 1:
//
//  Input: S = "ab#c", T = "ad#c"
//  Output: true
//  Explanation: Both S and T become "ac".
//  Example 2:
//
//  Input: S = "ab##", T = "c#d#"
//  Output: true
//  Explanation: Both S and T become "".
//  Example 3:
//
//  Input: S = "a##c", T = "#a#c"
//  Output: true
//  Explanation: Both S and T become "c".
//  Example 4:
//
//  Input: S = "a#c", T = "b"
//  Output: false
//  Explanation: S becomes "c" while T becomes "b".
//    Note:
//
//    1 <= S.length <= 200
//  1 <= T.length <= 200
//  S and T only contain lowercase letters and '#' characters.
//  Follow up:
//
//    Can you solve it in O(N) time and O(1) space?
  def backspaceCompare(S: String, T: String): Boolean = {
    def backspaceCompare(S: String, returnValue: String): String = {
      if (S.isEmpty) returnValue
      else if (S.head == '#') backspaceCompare(S.tail, returnValue.dropRight(1))
      else backspaceCompare(S.tail, returnValue :+ S.head)
    }

    backspaceCompare(S, "") == backspaceCompare(T, "")
  }
}
