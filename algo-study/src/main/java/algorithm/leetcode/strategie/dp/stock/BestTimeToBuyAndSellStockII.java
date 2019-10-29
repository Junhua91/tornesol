package algorithm.leetcode.strategie.dp.stock;


/**
 * as many transactions as you like
 */
public class BestTimeToBuyAndSellStockII {

    /**
     * 可以做无限次的交易，因此动态方程与k无关
     *
     * @param prices
     * @return
     */
    static public int maxProfit(int[] prices) {
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

    static public int maxProfit2(int[] prices) {

        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;

        int t_ik0 = 0;
        int t_ik1 = -prices[0];

        for (int i = 1; i < n; i++) {
            int temp = t_ik0;
            t_ik0 = Math.max(t_ik0, t_ik1 + prices[i]);
            t_ik1 = Math.max(t_ik1, temp - prices[i]);
        }

        return t_ik0;
    }


    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices));
    }
}
