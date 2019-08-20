package com.junhua.tornesol.leetcode.strategie.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    static public int eraseOverlapIntervals(int[][] intervals) {
        int count = 1;
        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        };
        Arrays.sort(intervals, comp);

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                intervals[i + 1] = intervals[i];
                continue;
            }
            count++;
        }

        return intervals.length - count;

    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int[][] interval2s = {{1, 2}, {1, 2}, {1, 2}};
        System.out.println(eraseOverlapIntervals(intervals));
        System.out.println(eraseOverlapIntervals(interval2s));
    }
}
