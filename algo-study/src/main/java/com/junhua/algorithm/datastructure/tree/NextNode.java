package com.junhua.algorithm.datastructure.tree;

/**
 * 1. 找到二叉树中任一节点的下一个节点;
 * 2. 在二叉树的中序遍历中，节点的下一个节点就是后继节点
 */
public class NextNode {


    /**
     * 1. 如果当前节点有右子树，则下一个节点是右子树里最左的那个节点
     * 2. 如果当前节点没有右子树，则向上查找...
     *
     * @param node
     * @return
     */
    public static Node nextNode(Node node) {

        if (node == null) return node;

        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    public static Node getLeftMost(Node node) {
        if (node == null) return null;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        Node test = head.left.left;
        System.out.println(test.value + " next: " + nextNode(test).value);
        System.out.println(test.value + " pre: " + PreNode.getPre(test));
        test = head.left.left.right;
        System.out.println(test.value + " next: " + nextNode(test).value);
        System.out.println(test.value + " pre: " + PreNode.getPre(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + nextNode(test).value);
        System.out.println(test.value + " pre: " + PreNode.getPre(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + nextNode(test).value);
        System.out.println(test.value + " pre: " + PreNode.getPre(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + nextNode(test).value);
        System.out.println(test.value + " pre: " + PreNode.getPre(test).value);
        test = head;
        System.out.println(test.value + " next: " + nextNode(test).value);
        System.out.println(test.value + " pre: " + PreNode.getPre(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + nextNode(test).value);
        System.out.println(test.value + " pre: " + PreNode.getPre(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + nextNode(test).value);
        System.out.println(test.value + " pre: " + PreNode.getPre(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + nextNode(test).value);
        System.out.println(test.value + " pre: " + PreNode.getPre(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + nextNode(test));
        System.out.println(test.value + " pre: " + PreNode.getPre(test).value);

    }
}
