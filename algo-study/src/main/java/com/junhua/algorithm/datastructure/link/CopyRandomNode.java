package com.junhua.algorithm.datastructure.link;

import java.util.HashMap;
import java.util.Map;


/**
 * 可以用来理解链表的引用问题
 */
public class CopyRandomNode {

    /**
     * 使用额外空间Map
     *
     * @param head
     * @return
     */
    public static Node copy(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node h = head;
        while (h != null) {
            map.put(h, new Node(h.value));
            h = h.next;
        }
        h = head;
        while (h != null) {
            map.get(h).next = map.get(h.next);
            map.get(h).rand = map.get(h.rand);
            h = h.next;
        }
        return map.get(head);
    }

    /**
     * 不使用额外空间
     *
     * @param head
     * @return
     */
    public static Node copy2(Node head) {
        if (head == null) return null;
        Node h = head;
        while (h != null) {
            Node next = h.next;
            h.next = new Node(h.value);
            h.next.next = next;
            h = next;
        }
        h = head;
        while (h != null) {
            Node rand = h.rand;
            h.next.rand = (rand == null) ? null : rand.next;
            h = h.next.next;
        }
        h = head;
        Node res = head.next;
        while (h != null) {
            Node next = h.next.next;
            Node newNext = h.next;
            h.next = next;
            newNext.next = (next != null) ? next.next : null;
            h = next;
        }
        return res;
    }

    public static Node copy3(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.value);
            Node next = cur.next;
            cur.next = newNode;
            newNode.next = next;
            cur = next;
        }
        cur = head;
        while (cur != null) {
            Node rand = cur.rand;
            cur.next.rand = (rand == null) ? null : rand.next;
            cur = cur.next.next;
        }
        cur = head;
        Node res = cur.next;
        Node result = res;
        while (cur != null) {
            Node next = cur.next.next;
            res.next = (next == null ? null : next);
            cur.next = next;
            cur = next;
            res = res.next;
        }
        return result;
    }


    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        Node res = copy3(head);
        LinkUtils.printNode(res);
        LinkUtils.printNode(head);

    }
}
