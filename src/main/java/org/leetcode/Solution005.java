package org.leetcode;

public class Solution005 {

    private String reverseString(String str) {
        byte[] strAsByteArray = str.getBytes();
        byte[] result = new byte[strAsByteArray.length];

        // Store result in reverse order into the
        // result byte[]
        for (int i = 0; i < strAsByteArray.length; i++)
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];
        return new String(result);
    }

    private boolean isPalindrome(String str) {
        return str.equals(reverseString(str));
    }

    public String longestPalindrome(String str) {
//        if (isPalindrome(str)) {
//            return str;
//        }
        String sub = "";
        int maxLen = (str.length()-1)/2;
        int subLength = str.length()/2;
        while(subLength > 1) {
            int lastIndex = str.length()-subLength;
            int lastStartIndex = lastIndex - subLength + 1;
            System.out.println(String.format("lastIndex = %d", lastIndex));
            for (int i = 0; i <= lastStartIndex; i++) {
                sub = str.substring(i, i + subLength);
                System.out.println(sub);
            }
            subLength--;
        }

        return str;
    }
}
