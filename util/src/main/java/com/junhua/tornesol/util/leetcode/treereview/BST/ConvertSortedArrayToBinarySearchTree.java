package com.junhua.tornesol.util.leetcode.treereview.BST;

import com.junhua.tornesol.util.leetcode.tree.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {

    static public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode res = find(nums, 0, nums.length-1);
        return res;
    }

    static public TreeNode find(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid =  (end +start) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = find(nums, start, mid - 1);
        root.right = find(nums, mid + 1, end);

        return root;
    }

    static public void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode res = sortedArrayToBST(nums);

        return;
    }
}
