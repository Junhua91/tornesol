package com.junhua.algorithm.leetcode.datastructure.tree;


import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {

    public static List<Integer> result = new ArrayList<>();

    static public boolean isSymmetric(TreeNode root) {
        inOrder(root);
        int length = result.size();
        if ((length & 1) == 0) return false;

        int midIndex = length / 2;

        int i = midIndex - 1;
        int j = midIndex + 1;
        while (i >= 0 && j < length) {
            if (result.get(i) != result.get(j)) return false;
            i--;
            j++;
        }
        return true;
    }


    public static void inOrder(TreeNode root) {
        if (root == null) {
            result.add(0);
            return;
        }
        inOrder(root.left);
        result.add(root.val);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1).setLeft(new TreeNode(2).setRight(new TreeNode(4)).setLeft(new TreeNode(3)))
                .setRight(new TreeNode(2).setLeft(new TreeNode(4)).setRight(new TreeNode(3)));

        TreeNode root2 = new TreeNode(1).setLeft(new TreeNode(2).setLeft(new TreeNode(2)))
                .setRight(new TreeNode(2).setLeft(new TreeNode(2)));
        System.out.println(isSymmetric2(root));
    }


    static public boolean isSymmetric2(TreeNode root) {
        if (root == null) return false;
        return find(root.left, root.right);
    }

    public static boolean find(TreeNode left, TreeNode right) {

        if (left == null || right == null) return left == right;

        if (left.val != right.val) return false;

        return find(left.left, right.right) && find(left.right, right.left);

    }
}
