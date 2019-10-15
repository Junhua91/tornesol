package com.junhua.tornesol.algorithm.leetcode.strategie.dp.knapsack.entierknapsack;


import java.util.Arrays;

/**
 * 完全背包
 * #1. 每件物品可以无限件使用
 * #2.动态方程
 * F[v] = max[f[v],f[v-C[i]]+V[i]]; v:C[i]->V(与01背包不同之处)
 * #3. 不带顺序：
 */
public class CoinChange {

    static public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int v = coin; v <= amount; v++) {
                dp[v] = Math.min(dp[v], dp[v - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(coinChange(coins, 5));
    }
}
