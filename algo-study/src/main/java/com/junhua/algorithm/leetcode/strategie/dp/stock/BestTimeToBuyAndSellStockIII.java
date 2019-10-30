package com.junhua.algorithm.leetcode.strategie.dp.stock;


/**
 * complete at most two transactions.
 */
public class BestTimeToBuyAndSellStockIII {


    static public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int[][][] dp = new int[n][3][2];
        dp[0][1][1] = -prices[0];
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][2][0] = Math.max(dp[i - 1][2][1] + prices[i], dp[i - 1][2][0]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            //从0到1的那一次，可以允许出现多次
            dp[i][1][1] = Math.max(dp[i - 1][1][1], -prices[i]);
        }
        return dp[n - 1][2][0];
    }

    static public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;

        int t_i10 = 0, t_i20 = 0;
        int t_i11 = -prices[0], t_i21 = -prices[0];

        for (int i = 1; i < n; i++) {
            t_i20 = Math.max(t_i20, t_i21 + prices[i]);
            t_i21 = Math.max(t_i21, t_i10 - prices[i]);
            t_i10 = Math.max(t_i10, t_i11 + prices[i]);
            t_i11 = Math.max(t_i11, -prices[i]);
        }
        return t_i20;
    }


    public static void main(String[] args) {
        int[] prices = {2, 1, 2, 0, 1};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices));
    }
}
