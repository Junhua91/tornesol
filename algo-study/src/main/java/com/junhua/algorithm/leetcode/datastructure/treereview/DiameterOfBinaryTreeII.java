package com.junhua.algorithm.leetcode.datastructure.treereview;

import com.junhua.algorithm.leetcode.datastructure.tree.TreeNode;

public class DiameterOfBinaryTreeII {

    public static int path;

    static public int diameterOfBinaryTree(TreeNode root) {
        find(root);
        return path;
    }

    static public int find(TreeNode root) {
        if (root == null) return 0;

        //仅用来表示层级关系
        int left = find(root.left);
        int right = find(root.right);
        path = Math.max(path, left + right);

        //返回一个节点的最大path
        return Math.max(left, right) + 1;
    }

    static public void main(String[] args) {

        TreeNode root = new TreeNode(1).setLeft(new TreeNode(2).setLeft(new TreeNode(4)).setRight(new TreeNode(5)))
                .setRight(new TreeNode(3));

        System.out.println(diameterOfBinaryTree(root));
    }
}
