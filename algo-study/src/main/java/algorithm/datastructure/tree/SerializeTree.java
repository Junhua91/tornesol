package algorithm.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 树的序列化和反序列化
 */
public class SerializeTree {


    /**
     * 1. 节点之间用'_' 隔开
     * 2. 空节点用 '#' 替代
     * 3. 按照一定的顺序来序列化：前、中、后序遍历，按层遍历
     *
     * @param head
     * @return
     */
    public static String serializeTree(Node head) {
        if (head == null) return null;
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node != null) sb.append("_" + node.value);
            else sb.append("_#");
            if (node != null) {
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return sb.toString();
    }


    public static Node deserializeTree(String str) {
        if (str == null || str.equals("")) return null;
        String[] elements = str.split("_");
        LinkedList<String> queue = new LinkedList<>();
        for (int i = 1; i < elements.length; i++) {
            queue.add(elements[i]);

        }
        return process(queue);
    }

    public static Node process(Queue<String> queue) {
        String str = queue.poll();
        if (str.equals("#")) {
            return null;
        }
        Node head = new Node(Integer.valueOf(str));
        head.left = process(queue);
        head.right = process(queue);
        return head;
    }

    public static void main(String[] args) {
        Node head = TreeUtils.createTestTree();
        String serializeTree = serializeTree(head);
        Node newHead = deserializeTree(serializeTree);

        System.out.println();
    }


}
