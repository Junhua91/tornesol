package com.junhua.tornesol.leetcode.strategie.dp;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthOfPairChain {

    static public int findLongestChain(int[][] pairs) {
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        int res = 0;
        Comparator<int[]> com = (a, b) -> a[1] - b[1];
        Arrays.sort(pairs, com);
        for (int i = 1; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }

    static public int findLongestChain2(int[][] pairs) {
        Comparator<int[]> com = (a, b) -> a[1] - b[1];
        Arrays.sort(pairs, com);
        int res = 1;
        int[] pre = pairs[0];
        for (int i = 1; i < pairs.length; i++) {
            if (pre[1] < pairs[i][0]) {
                res++;
                pre = pairs[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] pairs = {{7, 9}, {4, 5}, {7, 9}, {-7, -1}, {0, 10}, {3, 10}, {3, 6}, {2, 3}};
        System.out.println(findLongestChain(pairs));
        System.out.println(findLongestChain2(pairs));
    }
}
