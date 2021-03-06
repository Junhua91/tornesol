package com.junhua.algorithm.offer;

public class NowCoder10 {

    public int RectCover(int target) {

        if (target < 2) return 1;

        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[target];

    }
}
