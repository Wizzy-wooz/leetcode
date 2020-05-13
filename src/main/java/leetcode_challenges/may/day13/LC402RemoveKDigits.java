package leetcode_challenges.may.day13;

public class LC402RemoveKDigits {
//    Given a non-negative integer num represented as a string, remove k digits from the number
//    so that the new number is the smallest possible.
//
//            Note:
//    The length of num is less than 10002 and will be ≥ k.
//    The given num does not contain any leading zero.
//            Example 1:
//
//    Input: num = "1432219", k = 3
//    Output: "1219"
//    Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
//    Example 2:
//
//    Input: num = "10200", k = 1
//    Output: "200"
//    Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
//            Example 3:
//
//    Input: num = "10", k = 2
//    Output: "0"
//    Explanation: Remove all the digits from the number and it is left with nothing which is 0.
public String removeKdigits(String num, int k) {
    char[] array = num.toCharArray(); // use array as stack
    int end = 0; // [0, end) of the array is result
    int i = 0;   // pointer traverse 0 to n - 1
    while (i < array.length) {
        if (end == 0 || k == 0 || array[end - 1] <= array[i]) {
            array[end++] = array[i++]; // add element into the stack
        } else {
            while (k > 0 && end > 0 && array[end - 1] > array[i]) {
                end--; // pop top of stack
                k--;   // update number of elements needs to be removed
            }
        }
    }
    end -= k; // in case input is "11111" or "123456"
    // remove leading zeros
    int start = 0;
    while (start < end && array[start] == '0') {
        start++;
    }
    return start >= end ? "0" : String.valueOf(array, start, end - start);
}
}
