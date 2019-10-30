package com.junhua.algorithm.leetcode.strategie.dp;


/**
 * 1.  初始化dp
 * 2. 定义dp方程
 */
public class MinimumPathSum {

    static public int minPathSum(int[][] grid) {
        if (grid == null) return 0;
        int nbRows = grid.length;
        int nbCols = grid[0].length;
        int[][] dp = new int[nbRows][nbCols];

        dp[0][0] = grid[0][0];
        for (int j = 1; j < nbCols; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < nbRows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < nbRows; i++) {
            for (int j = 1; j < nbCols; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[nbRows - 1][nbCols - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        int[][] grid2 = {
                {1, 2, 5}, {3, 2, 1}
        };

        System.out.println(minPathSum(grid));
        System.out.println(minPathSum(grid2));
    }
}
