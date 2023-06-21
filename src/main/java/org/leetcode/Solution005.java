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
        if (isPalindrome(str)) {
            return str;
        }
        String sub;
        String toCheck;
        int currentSubstringLength = str.length()/2;
        while(currentSubstringLength > 0) {
            int lastIndex = str.length()-currentSubstringLength;
            int lastStartIndex = lastIndex - currentSubstringLength + 1;
            System.out.printf("lastIndex = %d%n", lastIndex);
            for (int i = 0; i <= lastStartIndex; i++) {
                sub = str.substring(i, i + currentSubstringLength);
                if (i != lastStartIndex) {
                    toCheck = sub + str.substring(i + currentSubstringLength, i + 2 * currentSubstringLength);
                    if(isPalindrome(toCheck)) {
                        return toCheck;
                    }
                    System.out.printf("Sub = %s, toCheck = %s%n", sub, toCheck);
                }
                toCheck = sub.substring(0, sub.length()-1) + str.substring(i + currentSubstringLength - 1, i + 2 * currentSubstringLength-1);
                if(isPalindrome(toCheck) && currentSubstringLength!=1) {
                    return toCheck;
                }
                System.out.printf("Sub = %s, toCheck = %s%n", sub, toCheck);
            }
            currentSubstringLength--;
        }
        return str;
    }
}
