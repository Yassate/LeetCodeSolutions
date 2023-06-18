package org.leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override public String toString() {
        int val = 0;
        int power = 0;
        ListNode currentNode = this;
        while(currentNode != null) {
            val = val + currentNode.val * (int)Math.pow(10, power++);
            currentNode = currentNode.next;
        }
        return String.format("%d", val);
    }
}

public class Solution002 {
    public void testCase1(){
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        addTwoNumbers(l1,l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currentNode1 = l1;
        ListNode currentNode2 = l2;
        ListNode currentOutputNode = new ListNode();
        ListNode outputNode = currentOutputNode;

        int transferValue = 0;

        while(!(currentNode1 == null && currentNode2 == null && transferValue == 0)) {
            int sum = 0;
            if(currentNode1 != null) {
                sum += currentNode1.val;
                currentNode1 = currentNode1.next;
            }
            if (currentNode2 != null) {
                sum += currentNode2.val;
                currentNode2 = currentNode2.next;
            }
            sum += transferValue;
            currentOutputNode.val = sum % 10;
            transferValue = Math.floorDiv(sum, 10);

            if (currentNode1 == null && currentNode2 == null && transferValue == 0) {
                break;
            }
            currentOutputNode.next = new ListNode();
            currentOutputNode = currentOutputNode.next;
        }
        return outputNode;
    }
}
