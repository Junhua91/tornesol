package com.junhua.algorithm.leetcode.strategie.dp.knapsack.knapsack01;

public class OnesAndZeroes {


    static public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int zeros = 0;
            int ones = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') zeros++;
                if (s.charAt(i) == '1') ones++;
            }

            for (int p = m; p >= zeros; p--) {
                for (int q = n; q >= ones; q--) {
                    dp[p][q] = Math.max(dp[p - zeros][q - ones] + 1, dp[p][q]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(strs, 5, 3));

    }

}
