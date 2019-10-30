package com.junhua.algorithm.leetcode.datastructure.graph.disjointset;


import com.junhua.algorithm.leetcode.datastructure.graph.UnionFind;

public class NumberOfIslands {

    static public int[][] D = {{1, 0}, {0, 1}};

    static public int numIslands(char[][] grid) {

        int m = grid.length, n = grid[0].length, zeros = 0;
        UnionFind unionFind = new UnionFind(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    zeros++;
                    continue;
                }
                for (int[] d : D) {
                    int x = i + d[0];
                    int y = j + d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                        unionFind.union(i * n + j, x * n + y);
                    }
                }
            }
        }
        return unionFind.getCount() - zeros;
    }

    static public void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        char[][] grid2 = {
                {'1'},
                {'1'}
        };
        System.out.println(numIslands(grid2));
    }
}

