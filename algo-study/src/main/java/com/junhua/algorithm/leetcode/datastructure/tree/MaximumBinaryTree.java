package com.junhua.algorithm.leetcode.datastructure.tree;


import java.util.ArrayList;
import java.util.List;

public class MaximumBinaryTree {


    static public TreeNode constructMaximumBinaryTree(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i : nums) list.add(i);
        return find(list);
    }

    static public TreeNode constructMaximumBinaryTree2(int[] nums) {

        if (nums == null) return null;
        return find2(nums, 0, nums.length-1);
    }

    static public TreeNode find(List<Integer> list) {
        if (list == null || list.isEmpty()) return null;
        int max = findMax(list);
        int index = list.indexOf(max);
        TreeNode root = new TreeNode(max);
        List<Integer> leftList = list.subList(0, index);
        List<Integer> rightList = list.subList(index + 1, list.size());
        if (leftList != null && leftList.size() > 0) root.left = find(leftList);
        if (rightList != null && rightList.size() > 0) root.right = find(rightList);
        return root;
    }

    static public TreeNode find2(int[] nums, int start, int end) {

        if (start > end) return null;

        int maxIndex = start;

        for (int i = start + 1; i < end + 1; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(nums[maxIndex]);

        root.left = find2(nums, start, maxIndex - 1);
        root.right = find2(nums, maxIndex + 1, end);

        return root;
    }

    public static int findMax(List<Integer> nums) {
        Integer max = Integer.MIN_VALUE;
        for (int i : nums) {
            if (max < i) max = i;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};

        TreeNode root = constructMaximumBinaryTree(nums);

        System.out.println();
    }
}
