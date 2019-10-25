package com.junhua.tornesol.algorithm.tree.base;


import com.junhua.tornesol.algorithm.tree.Node;

/**
 * AVL
 * 1. BST 在特殊情况下会退化成链表的结果，导致它的查找、插入、删除操作为O(N)
 * 2. 为了防止树形结构性能退化成链表，可以在插入节点的时候做相应的操作（比如：自旋）来调整树形结构：AVL，红黑树...
 * <p>
 * 自旋：左旋、右旋
 */
public class SelfBalanceOp extends BSTCommonOp {

    public SelfBalanceOp(int num) {
        super(num);
    }


    public void insert(int num) {
        Node newNode = super.add(num);
        rebalance(newNode);
    }

    public Node delete(int num) {
        Node destNode = super.get(head, num);
        if (destNode != null) {
            Node newNode = super.delete(destNode);
            if (newNode != null) {
                Node minNode = newNode.right == null ? newNode : findNextNode(newNode);
                recomputeHeight(minNode);
                rebalance(minNode);
            } else {
                recomputeHeight(destNode.parent);
                rebalance(destNode.parent);
            }
            return newNode;
        }
        return null;
    }

    /**
     * 1. 从当前节点往上走，找到左右高度差为2的就开始进行自旋操作;
     * 2. 每插入一个节点，都会往上重复
     * 3. 从子节点开始rebalance(删除、添加)
     *
     * @param node
     */
    public void rebalance(Node node) {
        if (node == null) return;
        Node originNode = node;
        while (node != null) {
            Node parent = node.parent;
            int lHeight = (node.left == null) ? -1 : node.left.height;
            int rHeight = (node.right == null) ? -1 : node.right.height;
            int heightDiff = lHeight - rHeight;

            //左子树高
            if (heightDiff == 2) {
                //LL.
                if (node.left.left != null) {
                    if (isSubTree(node.left.left, originNode.value))
                        avlRightRotate(node);
                    else avlLeftRightRotate(node);
                } else {
                    avlLeftRightRotate(node);
                }
            } else if (heightDiff == -2) {
                //RR： 这里判断有问题
                if (node.right.right != null) {
                    if (isSubTree(node.right.right, originNode.value))
                        avlLeftRotate(node);
                    else avlRightLeftRotate(node);
                } else {
                    avlRightLeftRotate(node);
                }
            } else {
                updateHeight(node);
            }
            node = parent;
        }
    }

    /**
     * 先左旋后右旋
     *
     * @param node
     * @return
     */
    public Node avlLeftRightRotate(Node node) {
        node.left = avlLeftRotate(node.left);
        return avlRightRotate(node);
    }

    /**
     * 先右旋再左旋
     *
     * @param node
     * @return
     */
    public Node avlRightLeftRotate(Node node) {
        node.right = avlRightRotate(node.right);
        return avlLeftRotate(node);
    }

    public Node avlLeftRotate(Node node) {
        Node tmp = leftRotate(node);
        updateHeight(tmp.left);
        updateHeight(tmp);
        return tmp;
    }

    public Node avlRightRotate(Node node) {
        Node tmp = rightRotate(node);
        updateHeight(tmp.right);
        updateHeight(tmp);
        return tmp;
    }

    private Node leftRotate(Node node) {
        if (node.right == null) return node;

        Node tmp = node.right;
        Node parent = node.parent;
        tmp.parent = parent;
        node.right = tmp.left;

        if (node.right != null) {
            tmp.left.parent = node;
        }

        tmp.left = node;
        node.parent = tmp;

        if (parent == null) {
            head = tmp;
        } else {
            if (parent.left == node) {
                parent.left = tmp;
            } else {
                parent.right = tmp;
            }
        }
        return tmp;
    }

    private Node rightRotate(Node node) {
        if (node.left == null) return node;

        Node tmp = node.left;
        Node parent = node.parent;
        tmp.parent = parent;
        node.left = tmp.right;

        if (node.left != null) {
            tmp.right.parent = node;
        }

        tmp.right = node;
        node.parent = tmp;

        if (parent == null) {
            head = tmp;
        } else {
            if (parent.left == node) {
                parent.left = tmp;
            } else {
                parent.right = tmp;
            }
        }
        return tmp;
    }


    private void updateHeight(Node node) {
        int lHeight = node.left == null ? -1 : node.left.height;
        int rHeight = node.right == null ? -1 : node.right.height;
        node.height = 1 + Math.max(lHeight, rHeight);
    }

    private void recomputeHeight(Node node) {
        while (node != null) {
            node.height = maxHeight(node.left, node.right) + 1;
            node = node.parent;
        }
    }

    /**
     * Returns higher height of 2 nodes.
     */
    private int maxHeight(Node node1, Node node2) {
        if (node1 != null && node2 != null) {
            return node1.height > node2.height ? node1.height : node2.height;
        } else if (node1 == null) {
            return node2 != null ? node2.height : -1;
        } else if (node2 == null) {
            return node1 != null ? node1.height : -1;
        }
        return -1;
    }
}
