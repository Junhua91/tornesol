package com.junhua.algorithm.leetcode.datastructure.link;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        if (head == null) return false;
        while (head != null) {
            if (nodeSet.contains(head)) return true;
            nodeSet.add(head);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if(head==null||head.next==null)return false;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast!=null&&fast.next!=null && slow!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)return true;
        }
        return false;
    }

}
