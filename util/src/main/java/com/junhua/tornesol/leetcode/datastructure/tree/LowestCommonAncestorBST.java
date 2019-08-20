package com.junhua.tornesol.leetcode.datastructure.tree;

public class LowestCommonAncestorBST {


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

        if (root.val == p.val || root.val == q.val) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        ;

        if (left != null && right != null) return root;

        if (left != null) return left;

        if (right != null) return right;

        return null;
    }

    static public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor2(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor2(root.left, p, q);
        } else return root;
    }

    static public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {

        while ((root.val - p.val) * (root.val - q.val) > 0) {
            root = (p.val > root.val) ? root.left : root.right;
        }

        return root;
    }

    public static void main(String[] args) {
        System.out.print(lowestCommonAncestor(TEST_TREE, new TreeNode(0), new TreeNode(4)).getVal());
    }

    static public TreeNode lowestCommonAncestor4(TreeNode root, TreeNode p, TreeNode q) {

        while ((root.val - p.val) * (root.val - q.val) > 0) {
            root = (root.val < p.val) ? root.right : root.left;
        }
        return null;
    }
}
