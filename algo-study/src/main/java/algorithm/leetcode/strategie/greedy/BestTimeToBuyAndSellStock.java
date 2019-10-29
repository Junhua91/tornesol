package algorithm.leetcode.strategie.greedy;

public class BestTimeToBuyAndSellStock {

    static public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int buy = prices[0];
        int benefit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else {
                benefit = Math.max(benefit, prices[i] - buy);
            }
        }
        return benefit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));

    }
}
