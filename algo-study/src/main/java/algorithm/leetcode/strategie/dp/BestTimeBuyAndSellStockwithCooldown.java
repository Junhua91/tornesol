package algorithm.leetcode.strategie.dp;

public class BestTimeBuyAndSellStockwithCooldown {

    static public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int len = prices.length;
        //0-> col(并不表示不买);1->buy;2->sell
        int[][] dp = new int[len][3];
        dp[0][1] = -prices[0];
        int profit = 0;
        for (int i = 1; i < len; i++) {
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);// dp[i-1][1]表示，当前保留的操锁是buy，不做任何其他的操作
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][2], dp[i - 1][1]));
            dp[i][2] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][2]);
            profit = Math.max(profit, Math.max(dp[i][0], Math.max(dp[i][1], dp[i][2])));
        }
        return profit;
    }

    static public void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }
}
