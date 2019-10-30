package com.junhua.algorithm.datastructure.link;


/**
 * 1. 删除单链表倒数第K个节点
 * 2. 删除双链表倒数第K个节点
 */
public class RemoveKthNode {

    public static Node removeKthNode(Node head, int k) {
        int size = 0;
        Node h = head;
        while (h != null) {
            size++;
            h = h.next;
        }
        if (k > size) return head;
        if (k == size) return head.next;
        int n = size - k;
        h = head;
        Node pre = null;
        while (n != 0) {
            pre = h;
            h = h.next;
            n--;
        }
        pre.next = h.next;
        return head;
    }

    public static Node removeKthNode2(Node head, int k) {
        if (head == null || k < 1) return head;
        Node cur = head;
        while (cur != null) {
            cur = cur.next;
            k--;
        }
        if (k == 0) return head.next;
        if (k < 0) {
            cur = head;
            while (++k != 0) {//++k 找到倒数第k的前面一个节点
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public static DoubleNode removeDoubleNode(DoubleNode head, int k) {
        if (head == null || k < 1) return head;
        DoubleNode cur = head;
        while (cur != null) {
            k--;
            cur = cur.next;
        }
        if (k == 0) return head.next;
        if (k < 0) {
            cur = head;
            while (++k != 0) {
                cur = cur.next;
            }
            DoubleNode newNext = cur.next.next;
            cur.next = newNext;
            if (newNext != null) newNext.last = cur;
        }
        return head;
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        Node res = removeKthNode2(head1, 6);
        return;
    }
}
