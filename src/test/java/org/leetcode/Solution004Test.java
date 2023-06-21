package org.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Solution004Test {

    private Solution004 solution = new Solution004();

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(new int[]{1,3}, new int[]{2}, 2.0),
                Arguments.of(new int[]{1,2}, new int[]{3,4}, 2.5),
                Arguments.of(new int[]{}, new int[]{1}, 1.0),
                Arguments.of(new int[]{}, new int[]{2,3}, 2.5),
                Arguments.of(new int[]{0,0}, new int[]{0,0}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    public void findMedianSortedArraysTest(int[] nums1, int[] nums2, double expectedMedian) {
        double result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(expectedMedian, result, 0.01D);
    }
}