package leetcode_challenges.may.day9;

public class LC367ValidPerfectSquare {
    //  Given a positive integer num, write a function which returns True if num is a perfect square else False.
//
//    Note: Do not use any built-in library function such as sqrt.
//
//  Example 1:
//
//  Input: 16
//  Output: true
//  Example 2:
//
//  Input: 14
//  Output: false
    public boolean isPerfectSquare(int x) {
        if (x == 1) {
            return true;
        }
        int l = 1, r = x / 2;
        while (l <= r) {
            int mid = r - (r - l) / 2;
            if (mid == (x / mid)) {
                return (x % mid == 0);
            } else if (mid < (x / mid)) {
                l = mid + 1;
            } else if (mid > (x / mid)) {
                r = mid - 1;
            }
        }
        return false;
    }
}
