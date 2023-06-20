package org.leetcode;

import java.util.Arrays;

public class Solution004 {

    public void testCase1(){
        double result = findMedianSortedArrays(new int[]{1,3}, new int[]{2});
        System.out.println(result);
    }

    public void testCase2(){
        double result = findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});
        System.out.println(result);
    }

    public void testCase3(){
        double result = findMedianSortedArrays(new int[]{}, new int[]{1});
        System.out.println(result);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int maximum;
        if (nums1.length == 0) {
            maximum = nums2[nums2.length-1];
        }
        else if (nums2.length == 0) {
            maximum = nums1[nums1.length-1];
        }
        else {
            maximum = Math.max(nums1[nums1.length-1], nums2[nums2.length-1]);
        }
        int maxSize = Math.max(nums1.length, nums2.length);
        int sizeDif = Math.abs(nums1.length - nums2.length);
        int[] fillArray = new int[sizeDif];
        Arrays.fill(fillArray, maximum);
        int[] nums3 = new int[maxSize];
        int[] nums4;

        if (nums1.length > nums2.length) {
            System.arraycopy(nums2, 0, nums3, 0, nums2.length);
            System.arraycopy(fillArray, 0, nums3, nums2.length, sizeDif);
            nums4 = nums1;
        }
        else {
            nums4 = nums2;
            System.arraycopy(nums1, 0, nums3, 0, nums1.length);
            System.arraycopy(fillArray, 0, nums3, nums1.length, sizeDif);
        }

        int[] result = new int[maxSize*2];
        int indexA = 0;
        int indexB = 0;
        for (int i = 0; i < maxSize*2; i++) {

            if (indexA != maxSize && (indexB == maxSize || nums3[indexA] < nums4[indexB])) {
                result[i] = nums3[indexA];
                indexA++;
            }
            else {
                result[i] = nums4[indexB];
                indexB++;
            }
        }

        int concatSize = nums1.length + nums2.length;
        int middleIndex = concatSize/2;
        if (concatSize % 2 == 1) {
            return result[middleIndex];
        }
        else {
            return (result[middleIndex] + result[middleIndex-1])/2D;
        }
    }
}
