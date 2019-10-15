package com.junhua.tornesol.algorithm.leetcode.strategie.greedy;

public class NonDecreasingArray {

    static public boolean checkPossibility(int[] nums) {
        if (nums == null) return false;
        int count = 0;
        for (int i = 1; i < nums.length  && count < 2; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
                if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                    nums[i] = nums[i - 1];
                } else {
                    nums[i - 1] = nums[i];
                }
            }
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        int[] nums = {3,4, 2, 3};
        System.out.println(checkPossibility(nums));
    }
}
