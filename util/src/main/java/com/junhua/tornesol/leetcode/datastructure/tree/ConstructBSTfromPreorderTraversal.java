package com.junhua.tornesol.leetcode.datastructure.tree;

public class ConstructBSTfromPreorderTraversal {

    public static int i = 0;

    static public TreeNode bstFromPreorder(int[] preorder) {

        if (preorder == null || preorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            find(root, preorder[i]);
        }
        return  root;
    }

    static public void find(TreeNode root, int val) {

        if (root.val < val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return;
            } else find(root.right, val);
        } else {
            if (root.left == null) {
                root.left = new TreeNode(val);
                return;
            } else find(root.left, val);
        }

    }


    static public TreeNode find2(int[] A, int bound) {
        if (i == A.length || A[i] > bound) return null;
        TreeNode root = new TreeNode(A[i++]);
        root.left = find2(A, root.val);
        root.right = find2(A, bound);
        return root;
    }

    public static void main(String[] args) {
        int[] preorders = {8, 5, 1, 7, 10, 12};
        TreeNode root = bstFromPreorder(preorders);
        System.out.println();
    }

}
