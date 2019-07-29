package com.junhua.tornesol.util.leetcode.datastructure.treereview;

import com.junhua.tornesol.util.leetcode.datastructure.tree.TreeNode;

public class BalancedBinaryTree {

    public static boolean result = true;

    static public boolean isBalanced(TreeNode root) {
        if (root == null) return false;
        find(root);
        return result;
    }


    static public int find(TreeNode root) {
        if (root == null) return 0;
        int leftLevel = find(root.left);
        int rightLevel = find(root.right);
        if (Math.abs(leftLevel - rightLevel) > 1) result = false;

        return Math.max(leftLevel, rightLevel) + 1;
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
