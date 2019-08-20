package com.junhua.tornesol.leetcode.strategie.search.dfs;

public class NumberOfIslands {

    static public int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static public int numIslands(char[][] grid) {

        if (grid.length == 0) return 0;
        int nbRows = grid.length;
        int nbCols = grid[0].length;
        int res = 0;
        for (int i = 0; i < nbRows; i++) {
            for (int j = 0; j < nbCols; j++) {
                if (grid[i][j] == '0') continue;
                find(grid, i, j);
                res++;
            }
        }
        return res;
    }

    static public void find(char[][] grid, int i, int j) {
        int nbRows = grid.length;
        int nbCols = grid[0].length;
        if (i < 0 || j < 0 || i >= nbRows || j >= nbCols || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        for (int[] xy : direction) {
            find(grid, i + xy[0], j + xy[1]);
        }
    }

    static public void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};

        System.out.println(numIslands(grid));
    }
}
