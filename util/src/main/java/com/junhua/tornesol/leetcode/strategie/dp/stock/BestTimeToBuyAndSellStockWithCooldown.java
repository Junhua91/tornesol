package com.junhua.tornesol.leetcode.strategie.dp.stock;


/**
 * #1. as many transactions as you like
 * #2. cooldown 1 day
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    static public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            if (i > 1) dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            else dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    static public int maxProfit2(int[] prices) {

        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;

        int t_ik0 = 0;
        int t_ik0_pre = 0;
        int t_ik1 = -prices[0];
        for (int i = 1; i < n; i++) {
            int tmp = t_ik0;
            t_ik0 = Math.max(t_ik0, t_ik1 + prices[i]);
            t_ik1 = Math.max(t_ik1, t_ik0_pre - prices[i]);
            t_ik0_pre = tmp;
        }

        return t_ik0;
    }

    static public void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices));
    }
}
