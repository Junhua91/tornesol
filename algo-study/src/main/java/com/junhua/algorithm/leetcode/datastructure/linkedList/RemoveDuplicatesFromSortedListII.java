package com.junhua.algorithm.leetcode.datastructure.linkedList;

public class RemoveDuplicatesFromSortedListII {

    static public ListNode deleteDuplicates(ListNode head) {

        if (head == null) return head;

        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }

        return head;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1).setNext(new ListNode(2).setNext(new ListNode(3).setNext(new ListNode(3)
                .setNext(new ListNode(4).setNext(new ListNode(4).setNext(new ListNode(5)))))));


        ListNode res = deleteDuplicates(head);

        return;
    }
}
