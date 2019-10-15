package com.junhua.tornesol.algorithm.leetcode.strategie.dp.stock;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIV {

    /**
     * Memory limit exceeded
     *
     * @param k
     * @param prices
     * @return
     */
    static public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int[][][] dp = new int[n][k + 1][2];
        if (k >= n >> 1) {
            return find(prices);
        }
        for (int j = 0; j <= k; j++) {
            dp[0][j][1] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = k; j > 0; j--) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }

    static public int maxProfit2(int k, int[] prices) {
        int n = prices.length;
        if (k >= n >> 1) {
            return find(prices);
        }
        int[] k1 = new int[k + 1];
        int[] k0 = new int[k + 1];
        Arrays.fill(k1, -prices[0]);

        for (int i = 1; i < n; i++) {
            for (int j = k; j > 0; j--) {
                k0[j] = Math.max(k0[j], k1[j] + prices[i]);
                k1[j] = Math.max(k1[j], k0[j - 1] - prices[i]);
            }
        }
        return k0[k];
    }

    /**
     * 不限次数
     *
     * @param prices
     * @return
     */
    static public int find(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];

    }

    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.println(maxProfit(2, prices));
        System.out.println(maxProfit2(2, prices));
    }
}
