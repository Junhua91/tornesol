package com.junhua.tornesol.util.leetcode.datastructure.treereview.BST;

import com.junhua.tornesol.util.leetcode.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST {

    public static TreeNode preNode = null;
    public static int min = Integer.MAX_VALUE;

    static public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        List<Integer> list = new ArrayList<>();
        findNums(root, list);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            min = Math.min(min, list.get(i + 1) - list.get(i));
        }
        return min;
    }

    public static void findNums(TreeNode root, List<Integer> list) {
        if (root == null) return;
        findNums(root.left, list);
        list.add(root.val);
        findNums(root.right, list);
    }


    static public int getMinimumDifference2(TreeNode root) {
        if (root == null) return 0;
        findNums2(root);
        return min;
    }

    public static void findNums2(TreeNode root) {
        if (root == null) return;
        findNums2(root.left);
        if (preNode != null) {
            min = Math.min(root.val - preNode.val, min);
        }
        preNode = root;
        findNums2(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1).setRight(new TreeNode(3).setLeft(new TreeNode(2)));

        System.out.println(getMinimumDifference2(root));

    }
}
