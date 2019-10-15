package com.junhua.tornesol.algorithm.leetcode.strategie.search.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] currentPos = queue.poll();
            for (int i = 0; i < size; i++) {
                for (int[] xy : direction) {
                    int row = currentPos[0] + xy[0];
                    int col = currentPos[1] + xy[1];
                    if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) continue;
                    res += grid[row][col];
                }
            }
        }
        return res;
    }
}
