package com.junhua.tornesol.algorithm.leetcode.datastructure.tree;

public class BinaryTreeTilt {

    public static int sum = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1).setLeft(new TreeNode(2).setRight(new TreeNode(5)).setLeft(new TreeNode(4)))
                .setRight(new TreeNode(3).setLeft(new TreeNode(6)).setRight(new TreeNode(7)));
        TreeNode root2 = new TreeNode(1).setRight(new TreeNode(3)).setLeft(new TreeNode(2));
        findTilt(root2);
        System.out.println(sum);
    }

    public static int findTilt(TreeNode root) {
        if (root == null) return 0;
        int left = findTilt(root.left);
        int right = findTilt(root.right);
        sum += Math.abs(left - right);
        return left + right + root.val;
    }
}
