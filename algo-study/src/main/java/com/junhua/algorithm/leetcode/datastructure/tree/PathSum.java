package com.junhua.algorithm.leetcode.datastructure.tree;

public class PathSum {


    static public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.val == sum && root.right == null && root.left == null) return true;
        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5).setLeft(new TreeNode(4).setLeft(new TreeNode(11).setLeft(new TreeNode(7)).setRight(new TreeNode(2))))
                .setRight(new TreeNode(8).setLeft(new TreeNode(13)).setRight(new TreeNode(4)));

        System.out.println(hasPathSum(root, 22));
    }
}
