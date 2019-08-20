package com.junhua.tornesol.leetcode.strategie.math;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {

    static public int maximumProduct(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int res1 = nums[0] * nums[1] * nums[len - 1];
        int res2 = nums[len - 1] * nums[len - 2] * nums[len - 3];
        return Math.max(res1, res2);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(maximumProduct(nums));
    }
}
