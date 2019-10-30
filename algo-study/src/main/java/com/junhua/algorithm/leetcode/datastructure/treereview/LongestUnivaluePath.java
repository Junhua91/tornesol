package com.junhua.algorithm.leetcode.datastructure.treereview;


import com.junhua.algorithm.leetcode.datastructure.tree.TreeNode;

public class LongestUnivaluePath {

    public static int max = 0;

    static public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        find(root);
        return max;
    }

    static public int find(TreeNode root) {
        if (root == null) return 0;
        int left = find(root.left);
        int right = find(root.right);
        int leftPath = (root.left != null && root.val == root.left.val) ? left + 1 : 0;
        int rightPath = (root.right != null && root.val == root.right.val) ? right + 1 : 0;
        max = Math.max(max, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5).setLeft(new TreeNode(4).setLeft(new TreeNode(1)).setRight(new TreeNode(1)))
                .setRight(new TreeNode(5).setRight(new TreeNode(5).setRight(new TreeNode(5))));

        int res = longestUnivaluePath(root);
        System.out.println(res);
    }
}
