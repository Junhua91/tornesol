package com.junhua.tornesol.leetcode.strategie.search.dfs;

public class MaxAreaOfIsland {

    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static public int maxAreaOfIsland(int[][] grid) {

        int nbRows = grid.length;
        int nbCols = grid[0].length;
        int res = 0;
        for (int i = 0; i < nbRows; i++) {
            for (int j = 0; j < nbCols; j++) {
                if (grid[i][j] == 0) continue;
                res = Math.max(find(grid, i, j),res);
            }
        }
        return res;
    }

    public static int find(int[][] grid, int i, int j) {
        int nbRows = grid.length;
        int nbCols = grid[0].length;
        if (i < 0 || j < 0 || i >= nbRows || j >= nbCols || grid[i][j] == 0) {
            return 0;
        }
        //标记访问过了的元素
        grid[i][j] = 0;
        int area = 1;

        for (int[] xy : direction) {
            area += (find(grid, i + xy[0], j + xy[1]));
        }

        return area;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

        System.out.println(maxAreaOfIsland(grid));

    }
}
