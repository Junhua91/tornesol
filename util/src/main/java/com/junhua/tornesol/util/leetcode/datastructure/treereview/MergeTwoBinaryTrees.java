package com.junhua.tornesol.util.leetcode.datastructure.treereview;

import com.junhua.tornesol.util.leetcode.datastructure.tree.TreeNode;

public class MergeTwoBinaryTrees {

    static public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        int val = ((t1 == null) ? 0 : t1.val) + ((t2 == null) ? 0 : t2.val);
        TreeNode root = new TreeNode(val);

        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1).setLeft(new TreeNode(3).setLeft(new TreeNode(5))).setRight(new TreeNode(2));
        TreeNode root2 = new TreeNode(2).setLeft(new TreeNode(1).setRight(new TreeNode(4)))
                .setRight(new TreeNode(3).setRight(new TreeNode(7)));

        TreeNode r = mergeTrees(root1, root2);


        System.out.println();


    }
}
