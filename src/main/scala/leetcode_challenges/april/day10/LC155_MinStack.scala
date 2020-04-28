package leetcode_challenges.april.day10

import java.util

class LC155_MinStack {

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

  var min: Integer = Integer.MAX_VALUE
  val stack: util.Stack[Integer] = new util.Stack[Integer]

    def push(x: Int) {
      if (x <= min) {
        stack.push(min)
        min = x
      }
      stack.push(x)
    }

    def pop() {
      if (stack.pop eq min) min = stack.pop
    }

    def top(): Int = stack.peek

    def getMin(): Int =min
}