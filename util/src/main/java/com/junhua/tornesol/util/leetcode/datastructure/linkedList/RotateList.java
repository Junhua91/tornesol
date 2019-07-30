package com.junhua.tornesol.util.leetcode.datastructure.linkedList;

public class RotateList {

    static public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;

        int size = 0;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int n = k % size;

        while (fast.next != null) {
            if (n != 0) {
                n--;
            } else {
                slow = slow.next;
            }
            fast = fast.next;
        }

        if (slow.next == null) return head;

        ListNode pre = slow.next;
        slow.next = null;
        fast.next = head;
        return pre;
    }

    static public ListNode find(ListNode head) {
        if (head == null) return null;
        ListNode temp = head;
        ListNode pre = null;

        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        pre.next = null;
        temp.next = head;
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(5 % 3);
        ListNode listNode = new ListNode(1).setNext(new ListNode(2).setNext(new ListNode(3).setNext(new ListNode(4).setNext(new ListNode(5)))));
        ListNode listNode2 = new ListNode(0).setNext(new ListNode(1).setNext(new ListNode(2)));
        ListNode head = rotateRight(listNode, 2);
        ListNode head2 = rotateRight(listNode2, 4);

        System.out.println();
    }
}
