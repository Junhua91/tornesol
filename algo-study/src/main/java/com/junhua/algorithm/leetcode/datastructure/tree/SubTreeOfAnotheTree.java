package com.junhua.algorithm.leetcode.datastructure.tree;

public class SubTreeOfAnotheTree {

    static public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) return false;
        return find(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    static public boolean find(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return find(s.left, t.left) && find(s.right, t.right);
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(3).setLeft(new TreeNode(4).setLeft(new TreeNode(1)).setRight(new TreeNode(2)))
                .setRight(new TreeNode(5));

        TreeNode s1 = new TreeNode(3).setLeft(new TreeNode(4).setLeft(new TreeNode(1)).setRight(new TreeNode(2).setLeft(new TreeNode(0))))
                .setRight(new TreeNode(5));

        TreeNode t = new TreeNode(4).setLeft(new TreeNode(1)).setRight(new TreeNode(2));

        System.out.println(isSubtree(s, t));
        System.out.println(isSubtree(s1, t));


    }

}
