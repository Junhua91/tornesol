package com.junhua.tornesol.algorithm.leetcode.strategie.math;

import java.util.Arrays;

public class MajorityElement {


    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        return nums[mid];
    }


    public int majorityElement2(int[] nums) {
        int cnt = 0, majority = nums[0];
        for (int num : nums) {
            majority = (cnt == 0) ? num : majority;
            cnt = (majority == num) ? cnt++ : cnt--;
        }
        return majority;
    }
}
