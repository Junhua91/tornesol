package algorithm.datastructure.link;

import java.util.Stack;

/**
 * 判断一个链表是否为回文结构
 */
public class PanlindromeLinkedList {


    /**
     * 时间复杂度O(N), 空间复杂度O(N)
     *
     * @param head
     * @return
     */
    public static boolean isPanlindrome(Node head) {
        if (head == null) return false;
        Node h1 = head;
        Node h2 = head;
        Stack<Node> stack = new Stack<>();
        while (h1 != null) {
            stack.push(h1);
            h1 = h1.next;
        }
        while (!stack.isEmpty()) {
            Node tmp = stack.pop();
            if (h2.value != tmp.value) {
                return false;
            }
            h2 = h2.next;
        }
        return true;
    }


    /**
     * 时间复杂度O(N), 空间复杂度O(N/2)
     *
     * @param head
     * @return
     */
    public static boolean isPanlindrome2(Node head) {
        if (head == null) return false;
        Node midNode = LinkUtils.midNode(head);
        Stack<Node> stack = new Stack<>();
        Node h = head;
        while (midNode != null) {
            stack.push(midNode);
            midNode = midNode.next;
        }
        while (!stack.isEmpty()) {
            Node tmp = stack.pop();
            if (tmp.value != h.value) return false;
            h = h.next;
        }
        return true;
    }


    /**
     * 时间复杂度O(N), 空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public static boolean isPanlindrome3(Node head) {
        if (head == null) return false;
        Node h = head;
        Node midNode = LinkUtils.midNode(head);
        Node reverse = LinkUtils.reverseNode(midNode);
        while (reverse != null) {
            if (h.value != reverse.value) return false;
            h = h.next;
            reverse = reverse.next;
        }
        return true;
    }

    public static void main(String[] args) {
//        Node head = new Node(1).setNext(new Node(2).setNext(new Node(3)
//                .setNext(new Node(3).setNext(new Node(2).setNext(new Node(1))))));
//        Node h2 = new Node(2);
//        System.out.println(isPanlindrome3(head));
//        System.out.print(isPanlindrome3(h2));
    }
}
