package com.junhua.tornesol.leetcode.datastructure.linkedList;

public class IntersectionOfTwoLinkedLists {

    static public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode reverseA = reverse(headA);
        ListNode reverseB = reverse(headB);

        ListNode res = null;

        while (reverseA != null && reverseB != null && reverseA.val == reverseB.val) {
            res = new ListNode(reverseA.val);
            reverseA = reverseA.next;
            reverseB = reverseB.next;
        }

        return res;
    }


   static public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }
    static ListNode reverse(ListNode cur) {
        if (cur == null) return cur;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    static public void main(String[] args) {
        ListNode A = new ListNode(4).setNext(new ListNode(1).setNext(new ListNode(8).setNext(new ListNode(4).setNext(new ListNode(5)))));
        ListNode B = new ListNode(5).setNext(new ListNode(0).setNext(new ListNode(1).setNext(new ListNode(8).setNext(new ListNode(4).setNext(new ListNode(5))))));

        ListNode res = getIntersectionNode2(A, B);
        return;
    }

}
