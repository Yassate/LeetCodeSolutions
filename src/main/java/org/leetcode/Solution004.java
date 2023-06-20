package org.leetcode;

import java.util.Arrays;

public class Solution004 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int concatenatedSize = nums1.length + nums2.length;
        int middleIndex = concatenatedSize/2;
        int[] result = new int[middleIndex+1];
        int indexA = 0, indexB = 0;

        for (int i = 0; i <= middleIndex; i++) {
            if (indexA != nums1.length && (indexB == nums2.length || nums1[indexA] < nums2[indexB])) {
                result[i] = nums1[indexA++];
            }
            else {
                result[i] = nums2[indexB++];
            }
        }

        return (concatenatedSize % 2 == 1) ? result[middleIndex] : (result[middleIndex] + result[middleIndex-1])/2D;
    }
}
