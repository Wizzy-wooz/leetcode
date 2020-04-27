package leetcode_30_days_challenge.day6;

import java.util.*;

public class LC49GroupAnagrams {
    //    Given an array of strings, group anagrams together.
//
//            Example:
//
//    Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//    Output:
//            [
//            ["ate","eat","tea"],
//            ["nat","tan"],
//            ["bat"]
//            ]
//    Note:
//
//    All inputs will be in lowercase.
//    The order of your output does not matter.
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
