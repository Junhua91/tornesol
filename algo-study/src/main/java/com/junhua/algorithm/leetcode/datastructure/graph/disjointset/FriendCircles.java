package com.junhua.algorithm.leetcode.datastructure.graph.disjointset;

import com.junhua.algorithm.leetcode.datastructure.graph.UnionFind;


/**
 * 1. relation is the edge
 * 2. friend is the node
 * 3. 注意这是对称的
 */
public class FriendCircles {

    static public int[][] D = {{1, 0}, {0, 1}};

    static public int findCircleNum(int[][] grid) {
        int m = grid.length, zeros = 0;

        UnionFind uf = new UnionFind(m);
        for (int i = 0; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                if (grid[i][j] == 0) {
                    zeros++;
                    continue;
                }
                for (int[] d : D) {
                    int x = i + d[0];
                    int y = j + d[1];
                    if (x >= 0 && x < m && y >= 0 && y < m && grid[x][y] == 1) {
                        uf.union(i * m + j, x * m + y);
                    }
                }
            }
        }
        return uf.getCount();
    }

    public static void main(String[] args) {
        int[][] M = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };

        System.out.println(findCircleNum(M));
    }
}
