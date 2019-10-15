package com.junhua.tornesol.algorithm.leetcode.datastructure.array;

public class MaxConsecutiveOnes {

    static public int findMaxConsecutiveOnes(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int count = 0;
                int j = i;
                while (j < nums.length && nums[j] == 1) {
                    j++;
                    count++;
                }
                res = Math.max(res, count);
                i = j;
            }
        }
        return res;
    }

    static public int findMaxConsecutiveOnes2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int cur = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            cur = nums[i] == 0 ? 0 : cur + 1;
            res = Math.max(res, cur);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes2(nums));
    }
}
