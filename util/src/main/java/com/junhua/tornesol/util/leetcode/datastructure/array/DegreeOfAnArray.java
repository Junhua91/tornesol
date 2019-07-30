package com.junhua.tornesol.util.leetcode.datastructure.array;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {

    static public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> res = new HashMap<>();
        int maxCount = 0;
        int finalResult = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (res.containsKey(num)) {
                int[] temp = res.get(num);
                temp[0]++;
                temp[2] = i;
            } else {
                //0->count;1->startIndex;2->endIndex
                res.put(num, new int[]{1, i, i});
            }
        }
        for (int[] value : res.values()) {
            if (maxCount < value[0]) {
                maxCount = value[0];
                finalResult = value[2] - value[1] + 1;
            } else if (maxCount == value[0]) {
                finalResult = Math.min(finalResult, value[2] - value[1] + 1);
            }
        }
        return finalResult;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 1};

        System.out.println(findShortestSubArray(nums));
        return;
    }
}
