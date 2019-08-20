package com.junhua.tornesol.leetcode.strategie.math;


/**
 * 1. sum + m * (n - 1) = x * n
 * 2.  x = minNum + m
 * => sum - minNum * n = m
 */
public class MinimumMovesToEqualArrayElements {


    static public int minMoves(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            sum += num;
        }
        return sum - min * nums.length;
    }

    public static void main(String[] args) {

        System.out.println(minMoves(new int[]{1, 2, 3}));
    }
}
