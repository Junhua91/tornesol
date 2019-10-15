package com.junhua.tornesol.algorithm.leetcode.strategie.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {


    /**
     * 时间复杂度：O(n*logn)
     *
     * @param intervals
     * @return
     */
    static public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) return intervals;
        Comparator<int[]> com = (a, b) -> a[0] - b[0];
        Arrays.sort(intervals, com);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] LAST = res.get(res.size() - 1);
            int[] CUR = intervals[i];
            if (LAST[1] >= CUR[0]) {
                LAST[1] = Math.max(LAST[1], CUR[1]);
            } else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] res = merge(intervals2);
        return;
    }
}
