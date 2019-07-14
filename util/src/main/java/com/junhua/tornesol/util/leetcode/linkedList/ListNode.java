package com.junhua.tornesol.util.leetcode.linkedList;

public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode setNext(ListNode next) {
        this.next = next;
        return this;
    }
}