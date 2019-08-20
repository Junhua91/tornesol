package com.junhua.tornesol.leetcode.strategie.dp;

public class NumArray {

    private int[] dp;

    public NumArray(int[] nums) {
        this.dp = nums;

        for (int i = 1; i < nums.length; i++) {
            dp[i] += dp[i - 1];
        }

    }

    public int sumRange(int i, int j) {
        if (i == 0) return dp[j];
        return dp[j] - dp[i - 1];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray array = new NumArray(nums);
        System.out.println(array.sumRange(0, 2));
        System.out.println(array.sumRange(2, 5));
        System.out.println(array.sumRange(0, 5));
    }
}
