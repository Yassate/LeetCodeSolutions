package org.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution005Test {

    private Solution005 solution = new Solution005();

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of("babad", "bab"),
                Arguments.of("cbbd", "bb"),
                Arguments.of("abba", "abba"),
                Arguments.of("abcba", "abcba"),
                Arguments.of("abcdedcba", "abcdedcba")
        );
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    public void longestPalindromeTest(String input, String expectedPalindrome) {
        String result = solution.longestPalindrome(input);
        assertEquals(result, expectedPalindrome);
    }
}