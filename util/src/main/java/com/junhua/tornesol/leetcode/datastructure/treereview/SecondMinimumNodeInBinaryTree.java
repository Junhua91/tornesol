package com.junhua.tornesol.leetcode.datastructure.treereview;

import com.junhua.tornesol.leetcode.datastructure.tree.TreeNode;

public class SecondMinimumNodeInBinaryTree {


    public static int secondMin = Integer.MAX_VALUE;
    public static int firstMin = 0;

    static public int findSecondMinimumValue(TreeNode root) {
        if (root.left == null || root.right == null) return -1;
        firstMin = root.val;
        find(root);
        return secondMin == Integer.MAX_VALUE ? -1 : secondMin;
    }

    static public void find(TreeNode root) {
        if (root == null) return;
        if (root.val > firstMin && root.val < secondMin) secondMin = root.val;
        else {
            find(root.left);
            find(root.right);
        }
    }


    static public int findSecondMinimumValue2(TreeNode root) {

        if (root.left == null || root.right == null) return -1;
        int leftVal = root.left.val;
        int rightVal = root.right.val;
        if (leftVal == root.val) leftVal = findSecondMinimumValue2(root.left);
        if (rightVal == root.val) rightVal = findSecondMinimumValue2(root.right);
        if (leftVal != -1 & rightVal != -1) return Math.min(leftVal, rightVal);
        if (leftVal == -1)return rightVal;
        else return leftVal;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2).setLeft(new TreeNode(2))
                .setRight(new TreeNode(5).setLeft(new TreeNode(5)).setRight(new TreeNode(7)));

        TreeNode root2 = new TreeNode(2).setLeft(new TreeNode(2).setLeft(new TreeNode(3)).setRight(new TreeNode(2)))
                .setRight(new TreeNode(5).setLeft(new TreeNode(5)).setRight(new TreeNode(7)));

        TreeNode root3 = new TreeNode(2).setLeft(new TreeNode(2)).setRight(new TreeNode(2));
        TreeNode root4 = new TreeNode(1).setLeft(new TreeNode(1).setRight(new TreeNode(1)).setLeft(new TreeNode(1)))
                .setRight(new TreeNode(2).setRight(new TreeNode(2)).setLeft(new TreeNode(2)));
        System.out.println(findSecondMinimumValue2(root3));
    }
}
