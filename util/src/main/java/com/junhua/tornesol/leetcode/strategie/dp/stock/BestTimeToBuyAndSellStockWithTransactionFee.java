package com.junhua.tornesol.leetcode.strategie.dp.stock;


/**
 * #1. as many transactions as you like
 * #2. pay the transaction fee for each transaction
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    static public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    static public int maxProfit2(int[] prices, int fee) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int t_ik0 = 0;
        int t_ik1 = -prices[0];
        for (int i = 1; i < n; i++) {
            t_ik0 = Math.max(t_ik0, t_ik1 + prices[i] - fee);
            t_ik1 = Math.max(t_ik1, t_ik0 - prices[i]);
        }
        return t_ik0;
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(maxProfit(prices, fee));
        System.out.println(maxProfit2(prices, fee));
    }
}
