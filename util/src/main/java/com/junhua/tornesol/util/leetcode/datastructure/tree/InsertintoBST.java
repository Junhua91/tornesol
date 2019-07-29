package com.junhua.tornesol.util.leetcode.datastructure.tree;

public class InsertintoBST {


    static public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) return null;

        if (val > root.val) {
            if (root.right == null) root.right = new TreeNode(val);
            else insertIntoBST(root.right, val);
        } else {
            if (root.left == null) root.left = new TreeNode(val);
            else insertIntoBST(root.left, val);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4).setLeft(new TreeNode(2).setLeft(new TreeNode(1)).setRight(new TreeNode(3)))
                .setRight(new TreeNode(7));

        insertIntoBST(root, 5);
        System.out.println();

    }
}
