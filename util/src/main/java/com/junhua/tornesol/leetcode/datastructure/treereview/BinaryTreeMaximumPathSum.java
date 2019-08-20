package com.junhua.tornesol.leetcode.datastructure.treereview;

import com.junhua.tornesol.leetcode.datastructure.tree.TreeNode;

public class BinaryTreeMaximumPathSum {

    public static int res = 0;

    static public int maxPathSum(TreeNode root) {
        find(root);
        return res;
    }

    public static int find(TreeNode root) {
        if (root == null) return 0;
        int left = find(root.left);
        int right = find(root.right);
        res = Math.max(res, left + right + root.val);
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {

    }
}
