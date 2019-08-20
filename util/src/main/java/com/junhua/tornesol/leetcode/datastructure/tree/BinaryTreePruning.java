package com.junhua.tornesol.leetcode.datastructure.tree;

public class BinaryTreePruning {

    static public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        if (root.val == 0 && (root.left == null) &&
                (root.right == null)) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1).setLeft(new TreeNode(1).setRight(new TreeNode(1)).setLeft(new TreeNode(1).setLeft(new TreeNode(0))))
                .setRight(new TreeNode(0).setLeft(new TreeNode(0)).setRight(new TreeNode(1)));

        TreeNode node = pruneTree(root);

        System.out.println();
    }
}
