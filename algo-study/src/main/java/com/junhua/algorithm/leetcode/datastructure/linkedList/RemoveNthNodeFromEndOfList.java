package com.junhua.algorithm.leetcode.datastructure.linkedList;

public class RemoveNthNodeFromEndOfList {

    static public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        int index = 0;
        ListNode temp = head;
        ListNode temp2 = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        if (size - n == 0) return head.next;
        while (temp2 != null) {
            index++;
            if (index == (size - n)) {
                if (temp2.next != null) {
                    temp2.next = temp2.next.next;
                }
            }
            temp2 = temp2.next;
        }
        return head;
    }

    /**
     * 用两个指针的位置差来表示n；当其中一个到达最后的时候，另一个就在要被移除的位置上
     *
     * @param head
     * @param n
     * @return
     */
    static public ListNode removeNthFromEnd2(ListNode head, int n) {


        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;

        while (fast != null) {
            if (n != 0) {
                n--;
            } else {
                pre = slow;
                slow = slow.next;
            }
            fast = fast.next;
        }

        if (pre == null) return slow.next;

        pre.next = slow.next;
        return head;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1).setNext(new ListNode(2).setNext(new ListNode(3).setNext(new ListNode(4).setNext(new ListNode(5)))));
        ListNode listNode2 = new ListNode(1).setNext(new ListNode(2).setNext(new ListNode(3).setNext(new ListNode(4).setNext(new ListNode(5)))));

        ListNode head = removeNthFromEnd(listNode, 2);
        ListNode head2= removeNthFromEnd2(listNode2, 2);

        System.out.println();
    }
}
