package com.junhua.tornesol.algorithm.tree;

public class Node {

    public int value;
    public Node left;
    public Node right;
    public Node parent;

    public Node(int value) {
        this.value = value;
    }


    /**
     * BST
     * 增加节点：节点添加到叶子节点
     *
     * @param num
     */
    public void add(int num) {
        Node node = this;
        while (node != null) {
            if (num > node.value) {
                if (node.right == null) {
                    node.right = new Node(num);
                    node.right.parent = node;
                    break;
                }
                node = node.right;
            } else {
                if (node.left == null) {
                    node.left = new Node(num);
                    node.left.parent = node;
                    break;
                }
                node = node.left;
            }
        }
    }

    public Node get(int num) {

        if (num == value) return this;
        Node node = this;

        while (node != null) {
            if (num > node.value) {
                node = node.right;
            } else if (num == node.value) {
                return node;
            } else {
                node = node.left;
            }
        }
        return null;
    }

    public void delete(int num) {
        Node node = get(num);
        if (node == null) return;
        //如果节点为叶子节点，直接将节点置为空
        if (node.left == null && node.right == null) {
            if (node == this) {
                node = null;
            } else {
                Node parent = node.parent;
                if (node == parent.left) parent.left = null;
                else parent.right = null;
            }
        } else if (node.left == null) {//如果右节点不为空
            Node leftMost = getLeftMost(node.right);
            node.parent.right = leftMost;
            leftMost.right = node.right;
        } else {
            node.parent.left = node.left;
        }
    }


    /**
     * 查找一个节点的后继节点
     *
     * @param node
     * @return
     */
    public Node findNext(Node node) {
        if (node == null) return null;
        if (node.right != null) {
            return getLeftMost(node);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public Node getLeftMost(Node node) {
        if (node == null) return null;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


    public static void main(String[] args) {
        Node head = new Node(4);
        head.add(1);
        head.add(6);
        head.add(2);
        head.add(8);
        head.add(3);
        head.add(5);

        Node n1 = head.get(7);
        Node n2 = head.get(5);
        head.delete(3);
        head.delete(1);
        head.delete(6);
        return;

    }
}
