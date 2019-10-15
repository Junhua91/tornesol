package com.junhua.tornesol.algorithm.leetcode.datastructure.linkedList;

public class AddTwoList {


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int num1 = transferToNum(l1);
        int num2 = transferToNum(l2);
        int sum = num1 + num2;
        ListNode result = new ListNode(sum % 10);
        transferToNodeList(sum / 10, result);
        return result;
    }

    public static int transferToNum(ListNode l) {
        int index = 0;
        int num = 0;

        while (l != null) {
            num += l.val * Math.pow(10, index);
            index++;
            l = l.next;
        }
        return num;
    }

    public static void transferToNodeList(int num, ListNode result) {
        if (num == 0) return;
        ListNode node = new ListNode(num % 10);
        result.next = node;
        transferToNodeList(num / 10, node);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1).setNext(new ListNode(9).setNext(new ListNode(9).setNext(new ListNode(9).setNext(new ListNode(9).setNext(new ListNode(9).setNext(new ListNode(9).setNext(new ListNode(9).setNext(new ListNode(9)))))))));

        ListNode result = addTwoNumbers(l1, l2);

        System.out.println();


    }


}
