package leetcode_30_days_challenge.day2;

import java.util.HashSet;
import java.util.Set;

public class LC202HappyNumber {
    /*Write an algorithm to determine if a number n is "happy".

    A happy number is a number defined by the following process: Starting with any positive integer,
    replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1
    (where it will stay), or it loops endlessly in a cycle which does not include 1.
    Those numbers for which this process ends in 1 are happy numbers.

    Return True if n is a happy number, and False if not.

    Example:
    Input: 19
    Output: true
    Explanation:
            12 + 92 = 82
            82 + 22 = 68
            62 + 82 = 100
            12 + 02 + 02 = 1
    */
    public boolean isHappy(int n) {
        Set<Integer> nums = new HashSet<>();
        int sum=0, digit;
        while (n != 0) {
            digit = n % 10;
            digit = digit * digit;
            sum += digit;
            n = n / 10;
            if (n == 0) {
                if (sum == 1) {
                    return true;
                } else if (!nums.add(sum)) {
                    return false;
                }
                n = sum;
                sum = 0;
            }
        }
        return false;
    }
}