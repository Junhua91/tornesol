package com.junhua.tornesol.algorithm.leetcode.datastructure.treereview.BST;

import com.junhua.tornesol.algorithm.leetcode.datastructure.tree.TreeNode;

public class ConvertBSTToGreaterTree {


    static private int sum = 0;

    static public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }


    static public void main(String[] args) {
        TreeNode root = new TreeNode(5).setLeft(new TreeNode(2)).setRight(new TreeNode(13));

        TreeNode s = convertBST(root);

        return;

    }
}
