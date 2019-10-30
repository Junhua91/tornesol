package com.junhua.algorithm.leetcode.datastructure.linkedList;

public class SwapNodesInPairs {

    static public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode third = head.next.next;
        ListNode res = second;
        while (second != null) {
            second.next = first;
            first.next = (third == null) ? null : (third.next == null ? third : third.next);
            first = third;
            second = (third == null) ? null : third.next;
            third = third == null ? null : ((third.next == null) ? null : third.next.next);
        }
        return res;

    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1)
                .setNext(new ListNode(2).setNext(new ListNode(3).setNext(new ListNode(4).setNext(new ListNode(5)))));
        ListNode res2 = swapPairs(listNode);
        System.out.println();
    }
}
