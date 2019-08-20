package com.junhua.tornesol.leetcode.strategie.dp;

public class BestTimeToBuyAndSellStockWithTransactionFee {


    static public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) return 0;
        int len = prices.length;
        //0->buy;1=>sell
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;

        System.out.println(maxProfit(prices, fee));


    }
}
