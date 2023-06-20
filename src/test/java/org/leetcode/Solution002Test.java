package org.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Solution002Test {

    private Solution002 solution = new Solution002();

    private static ListNode listNode(int[] digits) {
        ListNode l1 = new ListNode();
        ListNode output = l1;
        for (int i = 0; i < digits.length; i++) {
            l1.val = digits[i];
            l1.next = new ListNode();
            l1 = l1.next;
        }
        return output;
    }

    private static boolean checkIfAreEqual(ListNode l1, ListNode l2) {
        ListNode localL1 = l1;
        ListNode localL2 = l2;

        try {
            while(true) {
                if (localL1.val != localL2.val) {
                    return false;
                }
                localL1 = localL1.next;
                localL2 = localL2.next;
                if (localL1 == null && localL2 == null) {
                    return true;
                }
            }
        } catch (Exception e){
            return false;
        }
    }

    private static Stream<Arguments> provideParameters() {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        return Stream.of(
                Arguments.of(
                        new ListNode(2, new ListNode(4, new ListNode(3))),
                        new ListNode(5, new ListNode(6, new ListNode(4))),
                        new ListNode(7, new ListNode(0, new ListNode(8)))),
                Arguments.of(
                        new ListNode(0),
                        new ListNode(0),
                        new ListNode(0)),
                Arguments.of(
                        new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))),
                        new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))),
                        new ListNode(8, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(1)))))))))
        );
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    public void addTwoNumbersTest(ListNode l1, ListNode l2, ListNode expected) {
        ListNode result = solution.addTwoNumbers(l1, l2);
        assertTrue(checkIfAreEqual(result, expected));
    }
}