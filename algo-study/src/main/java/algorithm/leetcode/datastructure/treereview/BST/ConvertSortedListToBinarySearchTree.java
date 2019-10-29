package algorithm.leetcode.datastructure.treereview.BST;

import com.junhua.algorithm.leetcode.datastructure.linkedList.ListNode;
import com.junhua.algorithm.leetcode.datastructure.tree.TreeNode;

public class ConvertSortedListToBinarySearchTree {


    static public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode preMid = findMid(head);
        ListNode mid = preMid.next;
        preMid.next = null;
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }

    public static ListNode findMid(ListNode head) {
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

    public static void main(String[] args) {
        //-10,-3,0,5,9
        ListNode head = new ListNode(-10).setNext(new ListNode(-3).setNext(new ListNode(0)
                .setNext(new ListNode(5).setNext(new ListNode(9)))));

        TreeNode res = sortedListToBST(head);
        return;

    }
}
