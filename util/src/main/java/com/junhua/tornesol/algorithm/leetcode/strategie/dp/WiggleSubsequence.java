package com.junhua.tornesol.algorithm.leetcode.strategie.dp;

import java.util.Arrays;

public class WiggleSubsequence {
    static public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        //pre:dp[i][0]; +,- :dp[i][1]
        int n = nums.length;
        int[][] dp = new int[nums.length][2];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], 1);
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i][1] = dp[i - 1][0] + 1;
                dp[i][0] = dp[i - 1][0];
            } else if (nums[i] < nums[i - 1]) {
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = dp[i - 1][1];
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1];
            }
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println(wiggleMaxLength(nums));

    }
}
