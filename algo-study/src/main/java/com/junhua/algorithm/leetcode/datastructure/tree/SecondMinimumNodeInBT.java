package com.junhua.algorithm.leetcode.datastructure.tree;

public class SecondMinimumNodeInBT {

    static int min = 0;
    static int secondeMin = Integer.MAX_VALUE;

    static public int findSecondMinimumValue(TreeNode root) {
        if (root.left == null || root.right == null) return -1;
        min = root.val;
        dfs(root);
        return secondeMin == Long.MAX_VALUE ? -1 : secondeMin;
    }


    static public void dfs(TreeNode root) {
        if (root == null) return;
        if (min < root.val && root.val < secondeMin) {
            secondeMin = root.val;
        } else if (min == root.val) {
            dfs(root.left);
            dfs(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2).setLeft(new TreeNode(2))
                .setRight(new TreeNode(5).setLeft(new TreeNode(5)).setRight(new TreeNode(7)));

        TreeNode root2 = new TreeNode(2).setLeft(new TreeNode(2).setLeft(new TreeNode(3)).setRight(new TreeNode(2)))
                .setRight(new TreeNode(5).setLeft(new TreeNode(5)).setRight(new TreeNode(7)));

        TreeNode root3 = new TreeNode(2).setLeft(new TreeNode(2)).setRight(new TreeNode(2));
        TreeNode root4 = new TreeNode(1).setLeft(new TreeNode(1).setRight(new TreeNode(1)).setLeft(new TreeNode(1)))
                .setRight(new TreeNode(2).setRight(new TreeNode(2)).setLeft(new TreeNode(2)));
        System.out.println(findSecondMinimumValue(root2));
        System.out.println(findSecondMinimumValue(root4));
    }
}
