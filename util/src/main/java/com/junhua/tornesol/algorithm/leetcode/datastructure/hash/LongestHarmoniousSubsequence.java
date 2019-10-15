package com.junhua.tornesol.algorithm.leetcode.datastructure.hash;

import java.util.*;

public class LongestHarmoniousSubsequence {

    static public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for (int key : countMap.keySet()) {
            if (countMap.containsKey(key + 1)) {
                int countSum = countMap.get(key) + countMap.get(key + 1);
                max = Math.max(countSum, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        int max = findLHS(nums);
        System.out.println(max);
    }
}
