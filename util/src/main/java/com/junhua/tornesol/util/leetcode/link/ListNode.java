package com.junhua.tornesol.util.leetcode.link;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode setNext(ListNode next) {
        this.next = next;
        return this;
    }
}