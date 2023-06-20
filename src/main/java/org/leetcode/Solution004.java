package org.leetcode;

import java.util.Arrays;

public class Solution004 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int maximum = 1000000;
        int biggerArraySize = Math.max(nums1.length, nums2.length);
        int[] nums3 = new int[biggerArraySize];
        int[] nums4;

        if (nums1.length > nums2.length) {
            nums4 = nums1;
            System.arraycopy(nums2, 0, nums3, 0, nums2.length);
            Arrays.fill(nums3, nums2.length, nums3.length, maximum);
        }
        else {
            nums4 = nums2;
            System.arraycopy(nums1, 0, nums3, 0, nums1.length);
            Arrays.fill(nums3, nums1.length, nums3.length, maximum);
        }

        int concatenatedSize = nums1.length + nums2.length;
        int middleIndex = concatenatedSize/2;
        int[] result = new int[middleIndex+1];

        int indexA = 0;
        int indexB = 0;
        for (int i = 0; i <= middleIndex; i++) {
            if (indexA != biggerArraySize && (indexB == biggerArraySize || nums3[indexA] < nums4[indexB])) {
                result[i] = nums3[indexA];
                indexA++;
            }
            else {
                result[i] = nums4[indexB];
                indexB++;
            }
        }
        return (concatenatedSize % 2 == 1) ? result[middleIndex] : (result[middleIndex] + result[middleIndex-1])/2D;
    }
}
