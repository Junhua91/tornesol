package com.junhua.algorithm.offer;


/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class NowCoder15 {

    static public ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {


        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode res = ReverseList(head);
        return;
    }
}
