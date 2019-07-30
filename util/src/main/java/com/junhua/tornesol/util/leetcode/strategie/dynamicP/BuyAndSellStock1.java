package com.junhua.tornesol.util.leetcode.strategie.dynamicP;

public class BuyAndSellStock1 {

    public static int maxProfit(int[] prices) {

        int profit = 0;
        int lowest = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < lowest) {
                lowest = prices[i];
            } else {
                if (profit < prices[i] - lowest) {
                    profit = prices[i] - lowest;
                }
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};

        System.out.println(maxProfit(prices));
    }
}
