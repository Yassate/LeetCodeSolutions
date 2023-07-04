package org.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution008Test {

    private Solution008 solution = new Solution008();

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of("42", 42),
                Arguments.of("   -42", -42),
                Arguments.of("4193 with words", 4193),
                Arguments.of("-91283472332", -2147483648)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void myAtoiTest(String input, int expected) {
        int result = solution.myAtoi(input);
        assertEquals(expected, result);
    }
}