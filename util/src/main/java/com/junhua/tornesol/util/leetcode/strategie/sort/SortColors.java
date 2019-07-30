package com.junhua.tornesol.util.leetcode.strategie.sort;

public class SortColors {


    static public void sortColors(int[] nums) {
        int start = 0, end = nums.length - 1;

        for (int i = start; i <= end;) {
            //把所有的2 都放在右边
            if (nums[i] == 2) {
                swap(nums, i, end--);
            } else if (nums[i] == 0) {
                swap(nums, i, start++);
                i++;
            } else {
                i++;
            }
        }

    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] arg) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        return;
    }
}
