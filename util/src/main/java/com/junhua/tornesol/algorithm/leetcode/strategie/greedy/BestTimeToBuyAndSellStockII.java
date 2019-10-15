package com.junhua.tornesol.algorithm.leetcode.strategie.greedy;


/**
 * 一天可以进行多次操作：买+卖
 */
public class BestTimeToBuyAndSellStockII {

    static public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int benefit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                benefit += prices[i + 1] - prices[i];
            }
        }
        return benefit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
