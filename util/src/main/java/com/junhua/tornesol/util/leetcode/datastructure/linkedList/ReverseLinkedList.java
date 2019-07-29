package com.junhua.tornesol.util.leetcode.linkedList;

public class ReverseLinkedList {

    static public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        return find(head, null);
    }

    public static ListNode find(ListNode cur, ListNode pre) {
        if (cur == null) {
            return pre;
        }

        ListNode next = cur.next;
        cur.next = pre;
        return find(next, cur);
    }

    static public ListNode reverseList2(ListNode head) {
        if (head == null) return null;

        ListNode pre = null;
        ListNode cur = head;

        while (cur!= null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1)
                .setNext(new ListNode(2).setNext(new ListNode(3).setNext(new ListNode(4).setNext(new ListNode(5)))));

//        ListNode res = reverseList(listNode);
        ListNode res2 = reverseList2(listNode);

        System.out.println();
    }
}
