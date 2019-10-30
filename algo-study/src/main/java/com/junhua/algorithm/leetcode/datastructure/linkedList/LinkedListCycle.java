package com.junhua.algorithm.leetcode.datastructure.linkedList;

public class LinkedListCycle {

    static public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) return false;

        ListNode fast = head.next.next;
        ListNode slow = head.next;

        while (fast != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow.val == fast.val) return true;
        }

        return false;

    }
}
