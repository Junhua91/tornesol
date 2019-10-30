package com.junhua.algorithm.leetcode.datastructure.tree;

public class MergeTwoBinaryTrees {

    static public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        int val = ((t1 == null) ? 0 : t1.val) + ((t2 == null) ? 0 : t2.val);
        TreeNode node = new TreeNode(val);
        node.left = mergeTrees((t1 == null) ? null : t1.left, t2 == null ? null : t2.left);
        node.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return node;
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1).setLeft(new TreeNode(3).setLeft(new TreeNode(5))).setRight(new TreeNode(2));
        TreeNode root2 = new TreeNode(2).setLeft(new TreeNode(1).setRight(new TreeNode(4)))
                .setRight(new TreeNode(3).setRight(new TreeNode(7)));

        TreeNode r = mergeTrees(root1, root2);


        System.out.println();


    }
}
