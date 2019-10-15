package com.junhua.tornesol.algorithm.tree;

/**
 * 查找当前节点的前驱节点
 */
public class PreNode {

    public static Node getPre(Node node) {
        if (node == null) return node;

        if (node.left != null) {
            return getMostRight(node.left);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.right != node) {
                node = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    public static Node getMostRight(Node node) {
        if (node == null) return node;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}
