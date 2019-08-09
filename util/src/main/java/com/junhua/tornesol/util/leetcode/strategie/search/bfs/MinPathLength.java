package com.junhua.tornesol.util.leetcode.strategie.search.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class MinPathLength {

    static public int minPathLength(int[][] grids, int tr, int tc) {
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int nbRow = grids.length;
        int nbCol = grids[0].length;
        int sumPath = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            sumPath++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currentPos = queue.poll();
                for (int[] xy : direction) {
                    int row = currentPos[0] + xy[0];
                    int col = currentPos[1] + xy[1];
                    if (row < 0 || row >= nbRow || col < 0 || col >=nbCol || grids[row][col] == 0) continue;
                    queue.offer(new int[]{row, col});
                    if (row == tr && col == tc) return sumPath;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 1, 0, 1},
                {1, 0, 1, 0},
                {1, 1, 1, 1},
                {1, 0, 1, 1}};

        System.out.println(minPathLength(nums, 3, 3));

    }
}
