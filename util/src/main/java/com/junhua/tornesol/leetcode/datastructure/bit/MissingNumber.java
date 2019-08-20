package com.junhua.tornesol.leetcode.datastructure.bit;

public class MissingNumber {

    static public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ i ^ nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};

        System.out.println(missingNumber(nums));
    }
}
