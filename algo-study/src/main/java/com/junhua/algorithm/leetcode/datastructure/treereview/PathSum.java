package com.junhua.algorithm.leetcode.datastructure.treereview;

import com.junhua.algorithm.leetcode.datastructure.tree.TreeNode;

public class PathSum {

    static public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)return false;
        if (root!=null && root.left==null && root.right==null) {
            return (sum-root.val) == 0;
        }

        TreeNode left = (root == null) ? null : root.left;
        TreeNode right = (root == null) ? null : root.right;

        int val = (root == null) ? 0 : root.val;

        return hasPathSum(left, sum - val) ||
                hasPathSum(right, sum - val);

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5).setLeft(new TreeNode(4).setLeft(new TreeNode(11).setLeft(new TreeNode(7)).setRight(new TreeNode(2))))
                .setRight(new TreeNode(8).setLeft(new TreeNode(13)).setRight(new TreeNode(4)));

        System.out.println(hasPathSum(root, 22));
    }
}

