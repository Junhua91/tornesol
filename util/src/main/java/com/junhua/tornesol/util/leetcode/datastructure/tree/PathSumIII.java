package com.junhua.tornesol.util.leetcode.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumIII {

    static List<String> result = new ArrayList<>();

    static public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return find(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    static public int find(TreeNode root, int sum) {
        if (root == null) return 0;
        return ((root.val == sum) ? 1 : 0) +
                find(root.left, sum - root.val)
                + find(root.right, sum - root.val);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10).setLeft(new TreeNode(5).setLeft(new TreeNode(2)))
                .setRight(new TreeNode(-3).setRight(new TreeNode(11)));

    }
}