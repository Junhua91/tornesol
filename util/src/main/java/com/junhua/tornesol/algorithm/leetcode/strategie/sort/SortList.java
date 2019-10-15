package com.junhua.tornesol.algorithm.leetcode.strategie.sort;

import com.junhua.tornesol.algorithm.leetcode.datastructure.linkedList.ListNode;

public class SortList {

    static public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        pre.next = null;
        return merge(sortList(head), sortList(slow));
    }


    static public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode res = new ListNode(0);
        ListNode p = res;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = (l1 == null) ? l2 : l1;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-1).setNext(new ListNode(5).setNext(new ListNode(3).setNext(new ListNode(4).setNext(new ListNode(0)))));
        ListNode res = sortList(l1);
        System.out.println();


    }
}
