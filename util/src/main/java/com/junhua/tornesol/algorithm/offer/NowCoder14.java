package com.junhua.tornesol.algorithm.offer;


/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class NowCoder14 {

    public ListNode FindKthToTail(ListNode head, int k) {


        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            if (k <= 0) {
                slow = slow.next;
            }
            k--;
        }
        return k > 0 ? null : slow;
    }
}
