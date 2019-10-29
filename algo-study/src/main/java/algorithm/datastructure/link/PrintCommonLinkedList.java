package algorithm.datastructure.link;


import com.junhua.algorithm.leetcode.datastructure.linkedList.ListNode;

/**
 * 打印两个有序链表的公共部分
 */
public class PrintCommonLinkedList {


    /**
     * 时间复杂度O(N),空间复杂度O(1)
     *
     * @param l1
     * @param l2
     */
    public static void print(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return;
        while (l1 != null && l2 != null) {
            if (l1.val == l2.val) {
                System.out.print(l1.val + ",");
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1.val > l2.val) {
                l2 = l2.next;
            } else l1 = l1.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1).setNext(new ListNode(2).setNext(new ListNode(2)
                .setNext(new ListNode(4).setNext(new ListNode(5)))));
        ListNode l2 = new ListNode(6).setNext(new ListNode(6).setNext(new ListNode(6)
                .setNext(new ListNode(7).setNext(new ListNode(9)))));
        print(l1, l2);
    }

}
