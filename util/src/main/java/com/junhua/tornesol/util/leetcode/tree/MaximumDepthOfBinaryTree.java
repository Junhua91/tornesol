package com.junhua.tornesol.util.leetcode.tree;

public class MaximumDepthOfBinaryTree {

    static public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.max(left, right) + 1;
    }

    static public int maxDepth2(TreeNode root) {

        if (root == null) return 0;
        return find(root, 0);
    }

    static public int find(TreeNode root, int level) {
        if (root == null) return level;
        return Math.max(find(root.left, level + 1), find(root.right, level + 1));
    }

    static public void main(String[] agrs) {

        TreeNode root = new TreeNode(3).setLeft(new TreeNode(9))
                .setRight(new TreeNode(20).setLeft(new TreeNode(15)).setRight(new TreeNode(7)));
        System.out.println(maxDepth(root));
        System.out.println(maxDepth2(root));
    }
}
