package algorithm.datastructure.tree;


import java.util.Stack;

/**
 * 树的遍历
 */
public class TreeIterator {


    /**
     * 前序遍历
     *
     * @param head
     */
    public static void preOrder(Node head) {
        if (head == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.value);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    public static void inOrder(Node head) {
        if (head == null) return;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                Node node = stack.pop();
                System.out.println(node.value);
                head = node.right;
            }
        }
    }

    public static void postOrder(Node head) {
        if (head == null) return;
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(head);
        while (!stack1.isEmpty()) {
            Node node = stack1.pop();
            stack2.push(node);
            if (node.left != null) stack1.push(node.left);
            if (node.right != null) stack1.push(node.right);
        }
        while (!stack2.isEmpty()) {
            Node node = stack2.pop();
            System.out.println(node.value);
        }
    }


    public static void main(String[] args) {
        Node head = TreeUtils.createTestTree();
        System.out.println("pre order");
        preOrder(head);
        System.out.println("in order");
        inOrder(head);
        System.out.println("post order");
        postOrder(head);
    }
}
