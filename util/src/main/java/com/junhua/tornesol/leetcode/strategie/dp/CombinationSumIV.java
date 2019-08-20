package com.junhua.tornesol.leetcode.strategie.dp;

import java.util.Arrays;

public class CombinationSumIV {

    static public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num)
                    dp[i] = dp[i] + dp[i - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(combinationSum4(nums, 4));
    }
}
