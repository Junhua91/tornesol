package com.junhua.tornesol.algorithm.leetcode.datastructure.hash;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {


    static public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            numMap.put(num, 1);
        }
        for (int num : nums) {
            forward(numMap, num);
        }
        int max = 0;
        for (int key : numMap.keySet()) {
            max = Math.max(numMap.get(key), max);
        }
        return max;
    }

    static public int forward(Map numMap, int num) {
        if (!numMap.containsKey(num)) {
            return 0;
        }

        int count = (int) numMap.get(num);
        if (count > 1) return count;
        count = forward(numMap, num + 1) + 1;
        numMap.put(num, count);
        return count;
    }

    static public void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 3, 2};
        int max = longestConsecutive(nums);
        System.out.println(max);
    }
}
