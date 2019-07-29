package com.junhua.tornesol.util.leetcode.datastructure.treereview.BST;

import com.junhua.tornesol.util.leetcode.datastructure.tree.TreeNode;

public class TrimABinarySearchTree {

    static public TreeNode trimBST(TreeNode root, int L, int R) {

        if (root == null) return null;
        if (root.val < L) {
            return trimBST(root.right, L, R);
        } else if (root.val > R) {
            return trimBST(root.left, L, R);
        }

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1).setLeft(new TreeNode(0)).setRight(new TreeNode(2));
        TreeNode res = trimBST(root, 1, 2);
        return;
    }
}
