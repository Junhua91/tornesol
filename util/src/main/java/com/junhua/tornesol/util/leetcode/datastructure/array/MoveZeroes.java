package com.junhua.tornesol.util.leetcode.datastructure.array;

public class MoveZeroes {

    static public void moveZeroes(int[] nums) {

        if (nums == null || nums.length == 0) return;
        int t = 0;

        for (int num : nums) {
            if (num != 0) {
                nums[t] = num;
                t++;
            }
        }
        while (t < nums.length) {
            nums[t] = 0;
            t++;
        }
    }


    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);

        return;
    }
}
