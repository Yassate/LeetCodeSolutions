package org.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Solution003Test {

    private Solution003 solution = new Solution003();

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of("abcabcbb", 32),
                Arguments.of("bbbbb", 1),
                Arguments.of("pwwkew", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void lengthOfLongestSubstringTest(String toCheck, int expectedSubstringLength) {
        int result = solution.lengthOfLongestSubstring(toCheck);
        assertEquals(expectedSubstringLength, result);
    }
}