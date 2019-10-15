package com.junhua.tornesol.algorithm.leetcode.datastructure.tree;

public class SearchInBinarySearchTree {


    static public void main(String[] args) {

        TreeNode root = new TreeNode(4).setLeft(new TreeNode(2).setLeft(new TreeNode(1)).setRight(new TreeNode(3)))
                .setRight(new TreeNode(7));

        TreeNode r = searchBST(root, 2);

        System.out.println();


    }


    static public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) return null;

        if (root.val == val) return root;

        if(root.val>val)return searchBST(root.getLeft(), val);
        else return searchBST(root.getRight(), val);
    }
}
