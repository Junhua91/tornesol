package com.junhua.algorithm.datastructure.link;

import com.junhua.algorithm.sort.SortUtils;
import com.junhua.algorithm.leetcode.datastructure.linkedList.ListNode;

public class PartitionLinkedList {


    /**
     * 用数组记录，然后对数组进行partition;
     * 额外空间复杂度：O(N)
     *
     * @param head
     * @param pivot
     * @return
     */
    public static ListNode partition1(ListNode head, int pivot) {
        if (head == null || head.next == null) return head;
        int size = 0;
        ListNode h = head;
        while (h != null) {
            size++;
            h = h.next;
        }
        int[] nodes = new int[size];
        h = head;
        int index = 0;
        while (h != null) {
            nodes[index++] = h.val;
            h = h.next;
        }
        int LESS = -1;
        int CUR = 0;
        int MORE = size - 1;
        while (CUR < MORE) {
            if (pivot > nodes[CUR]) {
                SortUtils.swap(nodes, ++LESS, CUR++);
            } else if (pivot == nodes[CUR]) {
                CUR++;
            } else {
                SortUtils.swap(nodes, CUR, MORE--);
            }
        }
        ListNode res = new ListNode(-1);
        ListNode result = res;
        for (int node : nodes) {
            res.next = new ListNode(node);
            res = res.next;
        }
        return result.next;
    }


    /**
     * 将next值置为null，这样可以避免引入多余的元素
     *
     * @param head
     * @param pivot
     * @return
     */
    public static ListNode partition(ListNode head, int pivot) {
        if (head == null || head.next == null) return head;
        ListNode lStart = null;
        ListNode lEnd = null;
        ListNode eStart = null;
        ListNode eEnd = null;
        ListNode mStart = null;
        ListNode mEnd = null;
        ListNode h = head;
        while (h != null) {
            ListNode next = h.next;
            h.next = null;
            if (h.val < pivot) {
                if (lStart == null) {
                    lEnd = h;
                    lStart = h;
                } else {
                    lEnd.next = h;
                    lEnd = h;
                }
            } else if (h.val == pivot) {
                if (eStart == null) {
                    eEnd = h;
                    eStart = h;
                } else {
                    eEnd.next = h;
                    eEnd = h;
                }
            } else {
                if (mStart == null) {
                    mEnd = h;
                    mStart = h;
                } else {
                    mEnd.next = h;
                    mEnd = h;
                }
            }
            h = next;
        }
        if (lStart != null) {
            lEnd.next = (eStart != null) ? eStart : mStart;
            return lStart;
        }
        if (eStart != null) {
            eEnd.next = mStart;
            return eStart;
        }
        return mStart;
    }

    public static ListNode partition2(ListNode head, int pivot) {

        if (head == null || head.next == null) return head;
        ListNode sStart = null;
        ListNode sEnd = null;
        ListNode mStart = null;
        ListNode mEnd = null;
        ListNode gStart = null;
        ListNode gEnd = null;

        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = null;
            if (cur.val < pivot) {
                if (sStart == null) {
                    sStart = cur;
                    sEnd = cur;
                } else {
                    sEnd.next = cur;
                    sEnd = sEnd.next;
                }
            } else if (cur.val == pivot) {
                if (mStart == null) {
                    mStart = cur;
                    mEnd = cur;
                } else {
                    mEnd.next = cur;
                    mEnd = mEnd.next;
                }
            } else {
                if (gStart == null) {
                    gStart = cur;
                    gEnd = cur;
                } else {
                    gEnd.next = cur;
                    gEnd = gEnd.next;
                }
            }
            cur = next;
        }

        if (sStart != null) {
            sEnd.next = (mStart == null) ? gStart : mStart;
        }
        if (mStart != null) {
            mEnd.next = gStart;
        }
        return sStart != null ? sStart : ((mStart != null) ? mStart : gStart);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(9).setNext(new ListNode(0).setNext(new ListNode(4)
                .setNext(new ListNode(5).setNext(new ListNode(1).setNext(new ListNode(2))))));
        ListNode res = partition2(head, 3);
//        ListNode res2 = partition1(head, 3);
        return;
    }
}
