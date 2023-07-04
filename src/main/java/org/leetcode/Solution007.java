package org.leetcode;

public class Solution007 {

    private String reverseString(String str) {
        byte[] strAsByteArray = str.getBytes();
        byte[] result = new byte[strAsByteArray.length];

        for (int i = 0; i < strAsByteArray.length; i++)
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];
        return new String(result);
    }

    private String strAbs(String number) {
        return (number.charAt(0) == '-') ? number.substring(1) : number;
    }

    public int reverse(int x) {
        String valueX = strAbs(String.valueOf(x));
        String reversedX = (x>=0) ? reverseString(valueX) : "-" + reverseString(valueX);
        long tempValue = Long.parseLong(reversedX);
        return (Math.abs(tempValue) <= 2147483647) ? Integer.parseInt(reversedX) : 0;
    }
}
