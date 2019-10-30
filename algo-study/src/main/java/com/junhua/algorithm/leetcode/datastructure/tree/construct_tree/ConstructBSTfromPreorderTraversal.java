package com.junhua.algorithm.leetcode.datastructure.tree.construct_tree;

import com.junhua.algorithm.leetcode.datastructure.tree.TreeNode;

public class ConstructBSTfromPreorderTraversal {

    static public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null) return null;
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            find(root, preorder[i]);
        }
        return root;
    }

    public static void find(TreeNode root, int node) {
        if (root == null) return;
        if (node < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(node);
                return;
            } else {
                find(root.left, node);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(node);
                return;
            } else {
                find(root.right, node);
            }
        }
    }

    public static void main(String[] args) {
        int[] preorders = {8, 5, 1, 7, 10, 12};
        TreeNode root = bstFromPreorder(preorders);
        System.out.println();
    }
}
