package com.junhua.tornesol.util.leetcode.tree;

public class BalancedBinaryTree {

    static public boolean isBalanced(TreeNode root) {

        int left = findLevel(root.left, 0);
        int right = findLevel(root.right, 0);

        if (Math.abs(left - right) > 1) return false;
        else return true;
    }

    public static int findLevel(TreeNode root, int level) {
        if (root == null) return level;
        return Math.max(findLevel(root.left, level + 1), findLevel(root.right, level + 1));
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3).setLeft(new TreeNode(9))
                .setRight(new TreeNode(20).setLeft(new TreeNode(15)).setRight(new TreeNode(7)));


        TreeNode root2 = new TreeNode(1).setLeft(new TreeNode(2))
                .setRight(new TreeNode(2).setLeft(new TreeNode(3)).setRight(new TreeNode(4)).setLeft(new TreeNode(4)));
        System.out.println(isBalanced(root));
        System.out.println(isBalanced(root2));
    }
}
