package algorithm.leetcode.strategie.dp.stock;


/**
 * 股票系列
 * i-> i-th day; k: kth transaction; 0-> no stock, 1: have stock in hand
 * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+prices[i])
 * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0] - prices[i])
 * <p>
 * k+1 only happens when buy a stock
 */

/**
 * one transaction
 */
public class BestTimeToBuyAndSellStock {
    /**
     * 只有在有交易的时候，才会有值
     *
     * @param prices
     * @return
     */
    static public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int[][][] dp = new int[n][2][2];
        dp[0][0][1] = 0;
        dp[0][1][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][0][0] - prices[i], dp[i - 1][1][1]);
        }
        return dp[n - 1][1][0];
    }

    /**
     * 一次交易，dp方程与k的关系不大，可以将k去掉：注意和只能买卖一次的处理方式
     *
     * @param prices
     * @return
     */
    static public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //只能买卖一次
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }

    /**
     * 只用变量来表示动态方程
     *
     * @param prices
     * @return
     */
    static public int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int t_i10 = 0;
        int t_i11 = -prices[0];
        for (int i = 1; i < n; i++) {
            t_i10 = Math.max(t_i10, t_i11 + prices[i]);
            t_i11 = Math.max(t_i11, -prices[i]);
        }
        return t_i10;
    }


    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices));
        System.out.println(maxProfit3(prices));
    }

}