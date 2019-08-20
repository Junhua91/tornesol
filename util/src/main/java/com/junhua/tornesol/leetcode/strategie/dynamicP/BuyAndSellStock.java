package com.junhua.tornesol.leetcode.strategie.dynamicP;

public class BuyAndSellStock {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int length = prices.length;
        int[][][] mp = new int[length][3][2];
        mp[0][0][0] = 0;
        mp[0][0][1] = -prices[0];
        mp[0][1][0] = -10;
        mp[0][2][0] = -10;
        mp[0][1][1] = -10;
        mp[0][2][1] = -10;
        for (int i = 1; i < length; i++) {
            mp[i][0][0] = mp[i - 1][0][0];
            mp[i][0][1] = Math.max(mp[i - 1][0][1], mp[i - 1][0][0] - prices[i]);
            mp[i][1][0] = Math.max(mp[i - 1][1][0], mp[i - 1][0][1] + prices[i]);
            mp[i][1][1] = Math.max(mp[i - 1][1][1], mp[i - 1][1][0] - prices[i]);
            mp[i][2][0] = Math.max(mp[i - 1][2][0], mp[i - 1][1][1] + prices[i]);
        }
        int profit = Math.max(Math.max(mp[length - 1][1][0], mp[length - 1][2][0]), mp[length - 1][0][0]);
        return profit;
    }


    public static int maxProfit(int[] prices, int opNb, int stockNb) {
        if (prices == null || prices.length == 0) return 0;
        int length = prices.length;
        int[][][] mp = new int[length][opNb + 1][stockNb + 1];

        for (int m = 0; m <= opNb; m++) {
            for (int n = 0; n <= stockNb; n++) {
                mp[0][m][n] = -Integer.MAX_VALUE;
            }
        }

        mp[0][0][0] = 0;
        mp[0][0][1] = -prices[0];

        int profit = 0;


        for (int i = 1; i < length; i++) {
            for (int j = 1; j <= opNb; j++) {

                if (stockNb == 1) {
                    mp[i][j][0] = Math.max(mp[i - 1][j][0], mp[i - 1][j - 1][1] + prices[i]);
                    mp[i][j][1] = Math.max(mp[i - 1][j][1], mp[i - 1][j][0] - prices[i]);
                    profit = Math.max(Math.max(profit, mp[i][j][0]), mp[i][j][1]);
                }
//                for (int k = 1; k <stockNb; k++) {
//
//                    mp[i][j][k] = Math.max(mp[i - 1][j][k], mp[i - 1][j][k-1] - prices[i]);
//
//                   mp[i-1][j-1][k+1]+prices[i]
//
//                    mp[i][j][k] = mp[i - 1][j][k];
//                    mp[i][j][k + 1] = Math.max(mp[i - 1][j][k + 1], mp[i - 1][j][k] - prices[i]);
//                    mp[i][j + 1][k] = Math.max(mp[i - 1][j + 1][k], mp[i - 1][j][k + 1] + prices[i]);
//                    mp[i][j + 1][k + 1] = Math.max(mp[i - 1][j + 1][k + 1], mp[i - 1][j][k] - prices[i]);
//                }
            }
        }
//
//        for (int m = 0; m < opNb; m++) {
//            if (profit < mp[length - 1][m][0]) profit = mp[length - 1][m][0];
//        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices, 1, 1));
    }
}
