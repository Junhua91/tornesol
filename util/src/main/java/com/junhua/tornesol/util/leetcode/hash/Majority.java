package com.junhua.tornesol.util.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class Majority {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 3, 2, 3};
        System.out.print(maj1(nums));

    }

    static public int maj1(int[] nums) {
        Map<Integer, Integer> numCount = new HashMap<>();

        for (int num : nums) {
            if (numCount.containsKey(num)) {
                numCount.put(num, numCount.get(num) + 1);
            } else {
                numCount.put(num, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
            if (entry.getValue() > (nums.length / 2)) {
                return entry.getKey();
            }
        }

        return -1;
    }

}
