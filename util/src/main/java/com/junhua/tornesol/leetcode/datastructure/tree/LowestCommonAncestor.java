package com.junhua.tornesol.leetcode.datastructure.tree;
/**
 * leetCode 235、236
 */
public class LowestCommonAncestor {

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

    static public TreeNode find(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root.equals(p) || root.equals(q)) return root;

        TreeNode left = find(root.getLeft(), p, q);
        TreeNode right = find(root.getRight(), p, q);

        if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }

    public static void main(String[] args) {
        System.out.print(find(TEST_TREE, new TreeNode(0), new TreeNode(4)).getVal());
    }

}
