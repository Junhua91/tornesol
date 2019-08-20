package com.junhua.tornesol.leetcode.datastructure.linkedList;

public class SplitLinkedListInParts {

    static public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        if (root == null) return res;
        ListNode head = root;
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        int n = size / k;
        int mod = size % k;

        for (int i = 0; root!=null && i < k; i++) {
            res[i] = root;
            int curSize = n + ((mod-- > 0) ? 1 : 0);
            for (int j = 0; j < curSize - 1; j++) {
                root = root.next;
            }
            ListNode temp = root.next;
            root.next = null;
            root = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1).setNext(new ListNode(2).setNext(new ListNode(3).setNext(new ListNode(4).setNext(new ListNode(5)
                .setNext(new ListNode(6).setNext(new ListNode(7).setNext(new ListNode(8).setNext(new ListNode(9).setNext(new ListNode(10))))))))));
        //ListNode[] res = splitListToParts(root, 3);

        ListNode root2 = new ListNode(1).setNext(new ListNode(2).setNext(new ListNode(3).setNext(new ListNode(4))));
        ListNode[] res2 = splitListToParts(root2, 5);
        return;
    }
}
