package com.junhua.tornesol.algorithm.leetcode.datastructure.linkedList;

public class MergeTwoSortedLists {


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode result = new ListNode(0);
        find(l1, l2, result);
        return result.next;
    }

    public static void find(ListNode l1, ListNode l2, ListNode result) {
        if (l1 == null) {
            result.next = l2;
            return;
        }
        if (l2 == null) {
            result.next = l1;
            return;
        }
        if (l1.val < l2.val) {
            ListNode node = new ListNode(l1.val);
            result.next = node;
            l1 = l1.next;
            find(l1, l2, node);
        } else {
            ListNode node = new ListNode(l2.val);
            result.next = node;
            l2 = l2.next;
            find(l1, l2, node);
        }
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode result = new ListNode(0);

        ListNode temp1 = result;


        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                temp1.next = l1;
                l1 = l1.next;
            } else {
                temp1.next = l2;
                l2 = l2.next;
            }
            temp1 = temp1.next;
        }

        temp1.next = (l1 == null) ? l2 : l1;

        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1).setNext(new ListNode(2).setNext(new ListNode(4)));
        ListNode l2 = new ListNode(1).setNext(new ListNode(3).setNext(new ListNode(4)));

        ListNode result = mergeTwoLists(l1, l2);
        ListNode result2 = mergeTwoLists2(l1, l2);

        System.out.println();


    }
}
