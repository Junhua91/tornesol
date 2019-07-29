package com.junhua.tornesol.util.leetcode.dynamicP;

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * Once you pay the cost, you can either climb one or two steps.
 * You need to find minimum cost to reach the top of the floor,
 * and you can either start from the step with index 0,
 * or the step with index 1.
 */
public class MinCostClimbingStairs {

    static public int minCostClimbingStairs(int[] cost) {

        if (cost == null || cost.length == 0) return 0;
        if (cost.length == 1) return cost[0];
        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i <= cost.length; i++) {
            int costV = (i == cost.length) ? 0 : cost[i];
            dp[i] = Math.min(dp[i - 1] + costV, dp[i - 2] + costV);
        }
        return dp[cost.length];
    }

    static public void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] cost2 = {10, 15, 20};
        System.out.println(minCostClimbingStairs(cost));
        System.out.println(minCostClimbingStairs(cost2));
    }
}
