package leetcode_challenges.may.day5;

import java.util.HashMap;
import java.util.Map;

public class LC387FirstUniqueCharacterInAString {
    //    Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
//
//    Examples:
//
//    s = "leetcode"
//            return 0.
//
//    s = "loveleetcode",
//            return 2.
//    Note: You may assume the string contain only lowercase letters.
    public int firstUniqChar(String s) {
        Map<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
