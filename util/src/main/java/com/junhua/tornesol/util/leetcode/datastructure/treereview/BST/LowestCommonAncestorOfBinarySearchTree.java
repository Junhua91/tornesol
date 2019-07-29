package com.junhua.tornesol.util.leetcode.datastructure.treereview.BST;

import com.junhua.tornesol.util.leetcode.datastructure.tree.TreeNode;

public class LowestCommonAncestorOfBinarySearchTree {

    private static TreeNode TEST_TREE = new TreeNode(6)
            .setLeft(
                    new TreeNode(2).setLeft(
                            new TreeNode(0)
                    ).setRight(
                            new TreeNode(4).setLeft(
                                    new TreeNode(3)
                            ).setRight(
                                    new TreeNode(5)
                            )
                    )
            ).setRight(new TreeNode(8).setLeft(new TreeNode(7)).setRight(new TreeNode(9))
            );

    static public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else return root;
    }

    public static void main(String[] args) {
        System.out.print(lowestCommonAncestor(TEST_TREE, new TreeNode(2), new TreeNode(4)).getVal());
    }
}
