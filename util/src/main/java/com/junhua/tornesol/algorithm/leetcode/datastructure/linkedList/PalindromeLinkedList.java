package com.junhua.tornesol.algorithm.leetcode.datastructure.linkedList;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {


    /**
     * space O(N)
     *
     * @param head
     * @return
     */
    static public boolean isPalindrome(ListNode head) {

        if (head == null) return false;
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            if (!list.get(start).equals(list.get(end))) return false;
            start++;
            end--;
        }
        return true;
    }

    static public boolean isPalindrome2(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) slow = slow.next;
        cutListNode(head, slow);
        return isEqual(head, reverse(slow));
    }


    static public void cutListNode(ListNode head, ListNode slow) {
        while (head.next.val != slow.val) {
            head = head.next;
        }
        head.next = null;
    }

    static public boolean isEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    static public ListNode reverse(ListNode cur) {
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1)
                .setNext(new ListNode(2).setNext(new ListNode(2).setNext(new ListNode(1))));


        ListNode listNode1 = new ListNode(-129).setNext(new ListNode(-129));

        ListNode testNode = new ListNode(1).setNext(new ListNode(2).setNext(new ListNode(3)));

        ListNode reverseNode = reverse(testNode);

        System.out.println(isPalindrome2(listNode));


        System.out.println(-129 == -129);
    }

}
