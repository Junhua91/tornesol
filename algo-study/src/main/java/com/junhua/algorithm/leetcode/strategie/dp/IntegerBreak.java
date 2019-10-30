package com.junhua.algorithm.leetcode.strategie.dp;

import java.util.Arrays;

public class IntegerBreak {

    static public int integerBreak(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
        System.out.println(integerBreak(8));
        System.out.println(integerBreak(16));
    }
}
