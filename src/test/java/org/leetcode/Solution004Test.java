package org.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution004Test {

    @Test
    public void findMedianSortedArrays001() {
        Solution004 solution = new Solution004();
        double result = solution.findMedianSortedArrays(new int[]{1,3}, new int[]{2});
        assertEquals(result, 2.0D, 0.01D);
    }

    @Test
    public void findMedianSortedArrays002() {
        Solution004 solution = new Solution004();
        double result = solution.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});
        assertEquals(result, 2.5D, 0.01D);
    }

    @Test
    public void findMedianSortedArrays003() {
        Solution004 solution = new Solution004();
        double result = solution.findMedianSortedArrays(new int[]{}, new int[]{1});
        assertEquals(result, 1.0D, 0.01D);
    }
}