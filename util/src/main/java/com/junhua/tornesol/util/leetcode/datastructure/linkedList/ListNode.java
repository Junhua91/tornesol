package com.junhua.tornesol.util.leetcode.datastructure.linkedList;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode setNext(ListNode next) {
        this.next = next;
        return this;
    }
}