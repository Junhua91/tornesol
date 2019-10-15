package com.junhua.tornesol.algorithm.leetcode.strategie.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {

    static public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        };
        Arrays.sort(points, comp);
        int count = 1;

        int endPoint = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] < endPoint) continue;
            count++;
            endPoint = points[i][1];
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] point = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] point2 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        System.out.println(findMinArrowShots(point));
        System.out.println(findMinArrowShots(point2));
    }
}
