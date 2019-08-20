package com.junhua.tornesol.leetcode.datastructure.hash;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    static public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int rest = target - val;
            if (indexMap.containsKey(rest) && indexMap.get(rest) != i) {
                return new int[]{i, indexMap.get((target - val))};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int[] res = twoSum(nums, 6);
        return;
    }
}
