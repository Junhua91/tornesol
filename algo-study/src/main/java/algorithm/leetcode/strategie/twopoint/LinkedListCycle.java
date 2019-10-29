package algorithm.leetcode.strategie.twopoint;

import com.junhua.algorithm.leetcode.datastructure.linkedList.ListNode;

public class LinkedListCycle {

    static public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != null && fast.next != null) {
            if (fast == slow) return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1).setNext(new ListNode(2).setNext(new ListNode(1)));
        System.out.println(hasCycle(listNode));

    }
}
