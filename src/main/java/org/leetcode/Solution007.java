package org.leetcode;


public class Solution007 {

    private String reverseString(String str) {
        byte[] strAsByteArray = str.getBytes();
        byte[] result = new byte[strAsByteArray.length];

        for (int i = 0; i < strAsByteArray.length; i++)
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];
        return new String(result);
    }
    public int reverse(int x) {
        String valueX = String.format("%d", x);
        System.out.println(String.format("InputStr = %s, reversed = %s", valueX, reverseString(valueX)));
        return x;
    }
}
