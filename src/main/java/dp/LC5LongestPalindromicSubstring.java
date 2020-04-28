package dp;

public class LC5LongestPalindromicSubstring {
//    Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//
//    Example 1:
//
//    Input: "babad"
//    Output: "bab"
//    Note: "aba" is also a valid answer.
//            Example 2:
//
//    Input: "cbbd"
//    Output: "bb"
    //Manacher's Algorithm

    public String longestPalindrome(String s) {
        int n = 2 * s.length() + 1;
        char ch[] = new char[n];
        for (int i = 0; i < n - 1; i += 2) { //construct a new string by insert # between every two adjacent characters
            ch[i] = '#';
            ch[i + 1] = s.charAt(i / 2);
        }
        ch[n - 1] = '#';
        int arr[] = new int[n];  //Palindrome radius
        int R = 0, RC = 0; //RC is Palindrome center, R is Palindrome right boundary
        for (int i = 1; i < n; i++) {
            if (i >= R) {
                int j = 1;
                for (; i - j >= 0 && i + j < n && ch[i - j] == ch[i + j]; j++) ;
                R = i + j - 1;
                RC = i;
                arr[i] = j - 1;
            } else {
                int iL = RC - (i - RC);
                if (iL - arr[iL] < RC - arr[RC])
                    arr[i] = R - i;
                else if (iL - arr[iL] > RC - arr[RC])
                    arr[i] = arr[iL];
                else {
                    int j = arr[iL];
                    for (; i - j >= 0 && i + j < n && ch[i - j] == ch[i + j]; j++) ;
                    R = i + j - 1;
                    RC = i;
                    arr[i] = j - 1;
                }
            }
        }

        int maxR = 0, maxRC = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxR) {
                maxR = arr[i];
                maxRC = i;
            }
        }
        return s.substring((maxRC - maxR) / 2, (maxRC + maxR) / 2);
    }
}
