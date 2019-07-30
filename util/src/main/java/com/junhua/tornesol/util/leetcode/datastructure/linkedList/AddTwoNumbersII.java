package com.junhua.tornesol.util.leetcode.datastructure.linkedList;

import java.util.Stack;

public class AddTwoNumbersII {


    static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();

        fullFillStack(s1, l1);
        fullFillStack(s2, l2);

        int i = 0;

        ListNode res = new ListNode(0);

        while (!s1.isEmpty() || !s2.isEmpty() || i > 0) {


            ListNode node1 = null;
            ListNode node2 = null;

            if (!s1.isEmpty()) node1 = s1.pop();
            if (!s2.isEmpty()) node2 = s2.pop();

            int num = ((node1 != null) ? node1.val : 0) + ((node2 != null) ? node2.val : 0) + i;

            ListNode node = new ListNode(num / 10);
            res.val = num % 10;
            i = (num / 10 > 0) ? 1 : 0;
            node.next = res;
            res = node;
        }

        return res.val == 0 ? res.next : res;

    }


    static void fullFillStack(Stack stack, ListNode l) {
        if (l == null) return;

        while (l != null) {
            stack.push(l);
            l = l.next;
        }
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(5).setNext(new ListNode(6).setNext(new ListNode(4)));
        ListNode l2 = new ListNode(7).setNext(new ListNode(2).setNext(new ListNode(4).setNext(new ListNode(3))));

        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(5);

        ListNode result = addTwoNumbers(l1, l2);
        ListNode result2 = addTwoNumbers(l3, l4);

        System.out.println();


    }
}
