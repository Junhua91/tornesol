package com.junhua.algorithm.leetcode.strategie.dp;

public class HouseRobberII {


    /**
     * 去掉头或者尾
     *
     * @param nums
     * @return
     */
    static public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int benefit1 = find(nums, 1, nums.length);
        int benefit2 = find(nums, 0, nums.length - 1);
        return Math.max(benefit1, benefit2);
    }

    static public int find(int[] nums, int start, int end) {
        int length = end - start;
        int[][] dp = new int[length][2];
        dp[0][1] = nums[start];
        for (int i = start + 1; i < end; i++) {
            int index = i - start;
            dp[index][0] = Math.max(dp[index - 1][0], dp[index - 1][1]);
            dp[index][1] = dp[index - 1][0] + nums[i];
        }
        return Math.max(dp[length - 1][0], dp[length - 1][1]);
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int[] nums2 = {2, 3, 2};
        System.out.println(rob(nums));
        System.out.println(rob(nums2));

    }
}
