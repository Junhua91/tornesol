package com.junhua.algorithm.datastructure.link;

/**
 *
 */
public class LinkUtils {


    /**
     * 反转整个链表
     *
     * @param head
     * @return
     */
    public static Node reverseNode(Node head) {
        if (head == null || head.next == null) return head;
        Node pre = null;
        while (head != null) {
            Node temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }


    /**
     * 反转部分链表
     *
     * @param head
     * @param from
     * @param to
     * @return
     */
    public static Node reversePartNode(Node head, int from, int to) {
        if (head == null) return null;
        int N = 0;
        Node cur = head;
        Node pre = null;
        Node last = null;
        while (cur != null) {
            N++;
            pre = ((N == from - 1) ? cur : pre);
            last = ((N == to + 1) ? cur : last);
            cur = cur.next;
        }
        if (from > to || from < 1 || to > N) return head;
        Node node1 = (pre == null) ? head : pre.next;
        Node node2 = node1.next;
        node1.next = last;
        while (node2 != last) {
            Node next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if (pre != null) {
            pre.next = node1;
            return head;
        }
        return node1;
    }


    public static Node midNode(Node head) {
        if (head == null) return null;
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static Node copyNode(Node head) {
        if (head == null) return null;
        Node h = head;
        Node res = new Node(-1);
        Node result = res;
        while (h != null) {
            Node newNode = new Node(h.value);
            res.next = newNode;
            res = res.next;
            h = h.next;
        }
        return result.next;
    }

    public static void printNode(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static Node createExampleNode() {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next.next = head1;
        return head1;
    }


    public static void main(String[] args) {

    }
}
