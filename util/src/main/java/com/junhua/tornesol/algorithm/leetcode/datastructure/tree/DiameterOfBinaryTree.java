package com.junhua.tornesol.algorithm.leetcode.datastructure.tree;


/**
 * 关于求解max的问题可以定义一个全局变量来接收、比较最大的值。
 */
public class DiameterOfBinaryTree {

    public static int max = 0;


    static public int diameterOfBinaryTree(TreeNode root) {
        findMax(root);
        return max;
    }

    static public void main(String[] args) {

        TreeNode root = new TreeNode(1).setLeft(new TreeNode(2).setLeft(new TreeNode(4)).setRight(new TreeNode(5)))
                .setRight(new TreeNode(3));

        System.out.println(diameterOfBinaryTree(root));
    }

    static public int findMax(TreeNode root) {
        if (root == null) return 0;
        int left = findMax(root.left);
        int right = findMax(root.right);

        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
