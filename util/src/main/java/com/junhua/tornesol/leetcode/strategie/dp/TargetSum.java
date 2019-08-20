package com.junhua.tornesol.leetcode.strategie.dp;

public class TargetSum {

    static public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if ((sum + S) % 2 == 1) return 0;
        int target = (sum + S) >> 1;

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[target];
    }

    static public int findTargetSumWays2(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if ((sum + S) % 2 == 1) return 0;
        int target = (sum + S) >> 1;


        int[] dp2 = new int[nums.length + 1];
        dp2[0] = 1;
        for (int num : nums) {

            for (int j = target; j >= num; j--) {
                dp2[j] = dp2[j] + dp2[j - num];
            }
        }
        return dp2[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        System.out.println(findTargetSumWays(nums, 4));
    }
}
