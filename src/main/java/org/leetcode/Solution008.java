package org.leetcode;

public class Solution008 {
//  https://leetcode.com/problems/string-to-integer-atoi/

    private boolean isDigit(char character) {
        return (character > 47 && character < 58);
    }

    public int myAtoi(String str) {
        int value = 0;
        int sign = 1;
        int digit;
        boolean signDetermined = false;
        for (int i = 0; i< str.length(); i++) {
            char curChar = str.charAt(i);
            boolean doubleSign = signDetermined && (curChar == '+' || curChar == '-');
//            boolean nonDigitSignWhitespace = (curChar == '+' || curChar == '-');
            if (doubleSign) {
                break;
            }

            if (curChar == ' ') {
            } else if (isDigit(curChar)) {
                signDetermined = true;
                digit = curChar-48;
                if (value > (Integer.MAX_VALUE-digit-1)/10 && sign == -1) {
                    return Integer.MIN_VALUE;
                } else if (value > (Integer.MAX_VALUE-digit)/10) {
                    return Integer.MAX_VALUE;
                }
                value = value * 10 + (curChar-48);

            } else if (curChar == '-') {
                sign = -1;
            } else if (curChar != '+' ){
                break;
            }
            //System.out.println(str.charAt(i));
        }
        //System.out.println(value);
        sign = (sign != null) ? sign : 1;
        return value * sign;
    }
}
