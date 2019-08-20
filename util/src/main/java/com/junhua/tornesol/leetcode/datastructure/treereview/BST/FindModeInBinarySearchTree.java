package com.junhua.tornesol.leetcode.datastructure.treereview.BST;

import com.junhua.tornesol.leetcode.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindModeInBinarySearchTree {

    public static TreeNode preNode = null;
    public static int max = 0;
    public static int count = 1;


    static public int[] findMode(TreeNode root) {
        if (root == null) return new int[]{};

        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        return nums;

    }

    public static void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        if (preNode != null) {
            if (preNode.val == root.val) count++;
            else count = 1;
        }

        if (max < count) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (max == count) {
            list.add(root.val);
        }
        preNode = root;
        inOrder(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1).setRight(new TreeNode(2).setLeft(new TreeNode(2)));
        findMode(root);
    }
}
