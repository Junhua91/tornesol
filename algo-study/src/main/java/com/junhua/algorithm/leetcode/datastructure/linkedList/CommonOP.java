package com.junhua.algorithm.leetcode.datastructure.linkedList;

public class CommonOP {


    /**
     * 快、慢指针
     *
     * @param head
     * @return
     */
    public static ListNode midNode(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode fast = head.next.next;
        ListNode slow = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    /**
     * 获取中点节点前的一个节点
     *
     * @param head
     * @return
     */
    public static ListNode findPreMid(ListNode head) {
        ListNode pre = head;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }

    /**
     * 删除重复节点
     *
     * @param head
     * @return
     */
    static public ListNode deleteDuplicate(ListNode head) {

        if (head == null) return head;
        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicate(head);
        } else {
            head.next = deleteDuplicate(head.next);
        }
        return head;
    }

    /**
     * 反转
     *
     * @param head
     * @return
     */
    static public ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }


    public static void main(String[] args) {


        ListNode head = new ListNode(1).setNext(new ListNode(2).setNext(new ListNode(2)
                .setNext(new ListNode(4).setNext(new ListNode(5)))));

        ListNode mid = midNode(head);
        ListNode res = deleteDuplicate(head);
        ListNode reverse = reverse(head);

        System.out.println(mid.val);

    }
}
