package com.junhua.tornesol.util.leetcode.strategie.dp;

public class HouseRobber {

    static public int rob(int[] nums) {

        if (nums == null || nums.length == 0) return 0;
        int[][] dp = new int[nums.length + 1][2];
        dp[0][1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int[] nums2 = {2, 7, 9, 3, 1};
        int[] nums3 = {2, 1, 1, 2};
        System.out.println(rob(nums));
        System.out.println(rob(nums2));
        System.out.println(rob(nums3));
    }
}
