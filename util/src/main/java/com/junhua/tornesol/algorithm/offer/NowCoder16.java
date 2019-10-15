package com.junhua.tornesol.algorithm.offer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 */
public class NowCoder16 {

    static public ListNode Merge(ListNode list1, ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = new ListNode(-1);
        ListNode res = head;
        while (list1 != null || list2 != null) {

            if (list1 == null) {
                head.next = list2;
                break;
            }
            if (list2 == null) {
                head.next = list1;
                break;
            }

            if (list1.val > list2.val) {
                head.next = list2;
                list2 = list2.next;
            } else {
                head.next = list1;
                list1 = list1.next;
            }
            head = head.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        ListNode res = Merge(list1, list2);
        return;

    }
}
