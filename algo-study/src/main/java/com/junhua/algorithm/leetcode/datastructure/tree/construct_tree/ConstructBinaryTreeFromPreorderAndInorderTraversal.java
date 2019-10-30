package com.junhua.algorithm.leetcode.datastructure.tree.construct_tree;


import com.junhua.algorithm.leetcode.datastructure.tree.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    static public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode build(int[] preOrder, int pStart, int pEnd, int[] inOrder, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) return null;
        int index = iStart;
        while (preOrder[pStart] != inOrder[index]) {
            index++;
        }
        TreeNode root = new TreeNode(preOrder[pStart]);
        root.left = build(preOrder, pStart + 1, pStart + index - iStart, inOrder, iStart, index - 1);
        root.right = build(preOrder, pStart + index - iStart + 1, pEnd, inOrder, index + 1, iEnd);
        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};

        TreeNode res = buildTree(preOrder, inOrder);
        return;
    }
}
