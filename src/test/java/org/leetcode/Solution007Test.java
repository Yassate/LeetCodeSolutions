package org.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution007Test {

    private Solution007 solution = new Solution007();

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(23, 32),
                Arguments.of(-541, -145),
                Arguments.of(120, 21),
                Arguments.of(1534236469, 0),
                Arguments.of(-2147483648, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void reverse(int input, int expected) {
        int result = solution.reverse(input);
        assertEquals(expected, result);
    }
}