package leetcode_30_days_challenge.day10;

import java.util.Stack;

public class LC155MinStack {
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
        private int min;
        private Stack<Integer> stack;

        public LC155MinStack() {
            min = Integer.MAX_VALUE;
            stack = new Stack<Integer>();
        }

        public void push(int x) {
            if(x <= min){
                stack.push(min);
                min=x;
            }
            stack.push(x);
        }

        public void pop() {
            if(stack.pop() == min) min=stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
}
