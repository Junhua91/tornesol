package algorithm.leetcode.datastructure.treereview;

import com.junhua.algorithm.leetcode.datastructure.tree.TreeNode;

public class LowestCommonAncestorOfBinaryTree {

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
        if (root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }


    public static void main(String[] args) {
        System.out.print(lowestCommonAncestor(TEST_TREE, new TreeNode(0), new TreeNode(4)).getVal());
    }
}
