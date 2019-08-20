package com.junhua.tornesol.leetcode.datastructure.link;


class SwapNodeInPairs {

    public static ListNode swapPairs(ListNode head) {
        ListNode first = head;
        ListNode second = head.next;
        ListNode third = head.next.next;
        ListNode result = second;
        while (second != null) {
            second.next = first;
            first.next = (third == null) ? null : (third.next == null) ? third : third.next;
            first = third;
            second = (third == null) ? null : third.next;
            third = (third == null || third.next == null) ? null : third.next.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1).setNext(
                new ListNode(2).setNext(
                        new ListNode(3).setNext(new ListNode(4)))
        );

        ListNode result = swapPairs(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}


