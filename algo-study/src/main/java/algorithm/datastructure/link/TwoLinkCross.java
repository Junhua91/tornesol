package algorithm.datastructure.link;


/**
 * 两个单链表相交
 * 1. 两个无环链表：相交、不相交
 * 2. 两个有环链表相交：三种拓扑结构（不相交、入环节点相同，入环节点不相等）
 * 3. 一个有环，一个无环的链表不可能相交
 */
public class TwoLinkCross {


    public static Node getIntersect(Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return getIntersectNodeWithoutCycle(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return getIntersectNodeBothLoop(head1, loop1, head2, loop2);
        }
        //不存在一个有环，一个无环的情况
        return null;
    }


    /**
     * 无环链表相交
     *
     * @param head1
     * @param head2
     * @return
     */
    public static Node getIntersectNodeWithoutCycle(Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;
        int n1 = 0, n2 = 0;
        Node h1 = head1, h2 = head2;
        while (h1.next != null || h2.next != null) {
            if (h1.next != null) {
                n1++;
                h1 = h1.next;
            }
            if (h2.next != null) {
                n2++;
                h2 = h2.next;
            }
        }
        if (h1 != h2) return null;
        //让长链表先走到和短链表一样的长度，然后在一起走去找相同的节点
        h1 = head1;
        h2 = head2;
        Node longNode = (n1 > n2) ? h1 : h2;
        Node shortNode = (n1 > n2) ? h2 : h1;
        int index = (n1 > n2) ? n1 : n2;
        int limit = n1 > n2 ? n2 : n1;
        while (index != limit) {
            longNode = longNode.next;
            index--;
        }
        while (shortNode != longNode) {
            longNode = longNode.next;
            shortNode = shortNode.next;
        }
        return longNode;
    }


    /**
     * 两个有环链表
     *
     * @param head1
     * @param loop1
     * @param head2
     * @param loop2
     * @return
     */
    public static Node getIntersectNodeBothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        if (loop1 == loop2) {
            int n = 0;
            Node cur = head1;
            while (cur != loop1) {
                cur = cur.next;
                n++;
            }
            cur = head2;
            while (cur != loop1) {
                cur = cur.next;
                n--;
            }
            cur = (n > 0) ? head1 : head2;
            Node shortNode = (n > 0) ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                cur = cur.next;
                n--;
            }
            while (cur != shortNode) {
                cur = cur.next;
                shortNode = shortNode.next;
            }
            return cur;
        } else {
            Node cur = loop1.next;
            while (cur != loop1) {
                if (cur == loop2) {
                    return loop1;
                }
                cur = cur.next;
            }
            return null;
        }
    }


    /**
     * 获取入环的节点: 在快指针和慢指针相遇的时候，将快指针移动到head位置，然后再以相同的速度同时移动快慢指针，
     * 直到快慢指针相交，此时的相交点就是链表的入环点
     * <p>
     * 无环则返回null、有环则返回入环的点
     *
     * @param head
     */
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) return null;
        Node fast = head.next.next;
        Node slow = head.next;
        while (slow != fast) {
            if (fast == null && fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
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

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
//        System.out.println(getIntersectNodeWithoutCycle(head1, head2).value);


        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4
//        System.out.println(getLoopNode(head1).value);
//
        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersect(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersect(head1, head2).value);

    }

}
