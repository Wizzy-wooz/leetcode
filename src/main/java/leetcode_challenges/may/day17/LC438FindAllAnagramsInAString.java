package leetcode_challenges.may.day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC438FindAllAnagramsInAString {
    //  Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
//
//    Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
//
//  The order of output does not matter.
//
//    Example 1:
//
//  Input:
//    s: "cbaebabacd" p: "abc"
//
//  Output:
//  [0, 6]
//
//  Explanation:
//    The substring with start index = 0 is "cba", which is an anagram of "abc".
//  The substring with start index = 6 is "bac", which is an anagram of "abc".
//  Example 2:
//
//  Input:
//    s: "abab" p: "ab"
//
//  Output:
//  [0, 1, 2]
//
//  Explanation:
//    The substring with start index = 0 is "ab", which is an anagram of "ab".
//  The substring with start index = 1 is "ba", which is an anagram of "ab".
//  The substring with start index = 2 is "ab", which is an anagram of "ab".
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int N = s.length(), M = p.length();
        // Obtain the char frequency of p
        int[] pCount = new int[26];
        for(int i = 0; i < M; i++)
            pCount[p.charAt(i) - 'a']++;

        // Now check the char frequency of s every instance of size p
        int[] sCount = new int[26];
        for(int i = 0; i < N; i++) {
            sCount[s.charAt(i) - 'a']++;

            // Remove out of window chars
            if(i >= M)
                sCount[s.charAt(i-M) - 'a']--;

            if(i >= M-1 && Arrays.equals(pCount, sCount))
                result.add(i-M+1);
        }
        return result;
    }
}
