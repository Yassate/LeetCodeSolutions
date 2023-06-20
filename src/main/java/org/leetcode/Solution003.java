package org.leetcode;

import java.util.HashMap;

public class Solution003 {

    public int lengthOfLongestSubstring(String str) {
        HashMap<Character, Integer> currentSubstring = new HashMap<>();
        HashMap<Character, Integer> longestSubstring = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character curChar = str.charAt(i);
            if (currentSubstring.containsKey(curChar)) {
                i = currentSubstring.get(curChar);
                currentSubstring.clear();
                continue;
            }
            currentSubstring.put(curChar, i);
            if (currentSubstring.size() > longestSubstring.size()) {
                longestSubstring = new HashMap<>(currentSubstring);
            }
        }
        return longestSubstring.size();
    }
}
