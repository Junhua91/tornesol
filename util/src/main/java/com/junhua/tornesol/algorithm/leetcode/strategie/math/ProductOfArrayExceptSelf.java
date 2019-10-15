package com.junhua.tornesol.algorithm.leetcode.strategie.math;

public class ProductOfArrayExceptSelf {


    static public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] forward = new int[n];
        int[] back = new int[n];
        int[] res = new int[n];
        forward[0] = 1;
        back[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            forward[i] = forward[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            back[i] = back[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            res[i] = forward[i] * back[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[]res = productExceptSelf(nums);

        System.out.println(nums);
    }
}
