package com.junhua.tornesol.leetcode.datastructure.treereview;

import com.junhua.tornesol.leetcode.datastructure.tree.TreeNode;

public class DiameterOfBinaryTree {

    public static int path = 0;

    static public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        findMax(root);
        return path;
    }

    static int findMax(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = findMax(root.left);
        int rightDepth = findMax(root.right);
        path = Math.max(path, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }


    static public void main(String[] args) {

        TreeNode root = new TreeNode(1).setLeft(new TreeNode(2).setLeft(new TreeNode(4)).setRight(new TreeNode(5)))
                .setRight(new TreeNode(3));

        System.out.println(diameterOfBinaryTree(root));
    }
}
