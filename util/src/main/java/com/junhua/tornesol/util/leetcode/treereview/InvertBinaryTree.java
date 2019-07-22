package com.junhua.tornesol.util.leetcode.treereview;

import com.junhua.tornesol.util.leetcode.tree.TreeNode;

public class InvertBinaryTree {

    static public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.right);
        TreeNode right= invertTree(root.left);
        root.left = left;
        root.right = right;
        return root;
    }

    public static TreeNode find(TreeNode root) {
        if (root == null) return null;
        TreeNode left = find(root.right);
        TreeNode right= find(root.left);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4).setLeft(new TreeNode(2).setLeft(new TreeNode(1)).setRight(new TreeNode(3)))
                .setRight(new TreeNode(7).setLeft(new TreeNode(6)).setRight(new TreeNode(9)));

        TreeNode res = invertTree(root);
        return;
    }
}
