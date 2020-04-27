package leetcode_30_days_challenge.day26;

public class LC1143LongestCommonSubsequence {
    //  Given two strings text1 and text2, return the length of their longest common subsequence.
//
//    A subsequence of a string is a new string generated from the original string with some characters(can be none)
    // deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde"
    // while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
//
//
//
//    If there is no common subsequence, return 0.
//
//
//
//  Example 1:
//
//  Input: text1 = "abcde", text2 = "ace"
//  Output: 3
//  Explanation: The longest common subsequence is "ace" and its length is 3.
//  Example 2:
//
//  Input: text1 = "abc", text2 = "abc"
//  Output: 3
//  Explanation: The longest common subsequence is "abc" and its length is 3.
//  Example 3:
//
//  Input: text1 = "abc", text2 = "def"
//  Output: 0
//  Explanation: There is no such common subsequence, so the result is 0.
    public int longestCommonSubsequence(String text1, String text2) {
        int[] dp = new int[text2.length()+1];
        for(int i = 0; i< text1.length(); i++){
            int prev = dp[0];
            for(int j = 1; j < dp.length; j++){
                int temp = dp[j];
                if(text1.charAt(i) != text2.charAt(j-1)){
                    dp[j] = Math.max(dp[j-1], dp[j]);
                }else{
                    dp[j] = prev +1;
                }
                prev = temp;
            }
        }
        return dp[dp.length-1];
    }
}
