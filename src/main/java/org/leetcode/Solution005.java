package org.leetcode;

public class Solution005 {

    private boolean isPalindrome(String str) {
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(str.length() - i - 1) != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome(String str) {
        String toReturn = str.substring(0,1);
        if (isPalindrome(str)) {
            return str;
        }
        for (int currentSubstrLen = str.length()/2; currentSubstrLen > 0; currentSubstrLen--) {
            int lastIdx = str.length()-currentSubstrLen;
            int lastStartIdx = lastIdx - currentSubstrLen + 1;
            for (int startIdx = 0; startIdx <= lastStartIdx; startIdx++) {
                String substrAfter, toCheck1 = "", toCheck2 = "";
                String substr = str.substring(startIdx, startIdx + currentSubstrLen);
                if (startIdx != lastStartIdx) {
                    substrAfter = str.substring(startIdx + currentSubstrLen, startIdx + 2 * currentSubstrLen);
                    toCheck1 = substr + substrAfter;
                    //System.out.println(String.format("substr = %s, substrAfter = %s, toCheck1 = %s, startIdx = %d, lastStartIdx = %d, currentSubstrLen = %d", substr, substrAfter, toCheck1, startIdx, lastStartIdx, currentSubstrLen));
                    if(isPalindrome(toCheck1) && toCheck1.length() > toReturn.length()) {
                        return toCheck1;
                    }
                }
                if (currentSubstrLen != 1) {
                    substrAfter = str.substring(startIdx + currentSubstrLen, startIdx + 2 * currentSubstrLen-1);
                    toCheck2 = substr + substrAfter;
                    //System.out.println(String.format("substr = %s, substrAfter = %s, toCheck2 = %s, startIdx = %d, lastStartIdx = %d, currentSubstrLen = %d", substr, substrAfter, toCheck2, startIdx, lastStartIdx, currentSubstrLen));
                    if(isPalindrome(toCheck2) && toCheck2.length() > toReturn.length()) {
                        toReturn = toCheck2;
                    }
                }
            }
        }
        return toReturn;
    }
}
