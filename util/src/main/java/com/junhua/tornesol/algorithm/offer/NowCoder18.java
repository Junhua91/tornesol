package com.junhua.tornesol.algorithm.offer;

public class NowCoder18 {

    static public void Mirror(TreeNode root) {
        if (root == null) return;
        find(root);
    }

    public static TreeNode find(TreeNode root) {
        if (root == null) return null;
        TreeNode left = find(root.right);
        TreeNode right = find(root.left);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);

        Mirror(root);

        return;
    }
}
