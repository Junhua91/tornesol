package com.junhua.tornesol.algorithm.leetcode.strategie.dp.knapsack.knapsack01;

/**
 * 0、1被背包
 * #1. 每件物品仅有一件，可以选择放或者不放
 * #2. 动态方程：F[i,v] = max(F[i-1,v],F[i-1,v-C[i]]+V[i])
 * #3. 空间优化：（v：V->C[i]）
 * F[v] = max(F[v],F[v-C[i]]+V[i])
 * #4. 初始化问题
 * a. 恰好装满：F[0]=0; F[1...V]=infinity
 * b. 尽力大: F[0..V] = 0
 */
public class PartitionEqualSubsetSum {

    static public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum & 1) == 1) return false;
        int target = sum >> 1;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            int weight = nums[i - 1];
            for (int j = target; j >= weight; j--) {
                dp[j] = dp[j] || dp[j - weight];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5};
        System.out.println(canPartition(nums));
    }

}
