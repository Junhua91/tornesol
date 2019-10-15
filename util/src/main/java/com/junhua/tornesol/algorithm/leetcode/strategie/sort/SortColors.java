package com.junhua.tornesol.algorithm.leetcode.strategie.sort;

public class SortColors {


    static public void sortColors(int[] nums) {
        int start = 0, end = nums.length - 1;
        for (int i = start; i <= end; ) {
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

    /**
     * 时间复杂度O(N)
     *
     * @param nums
     */
    static public void sortColors2(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int[] array = {0, 1, 2};
        int LESS = 0;
        int CUR = 0;
        int LEN = nums.length;
        for (int num : array) {
            CUR = LESS;
            while (CUR < LEN) {
                if (nums[CUR] == num) {
                    swap(nums, CUR, LESS++);
                }
                CUR++;
            }
        }
    }


    public static void swap(int[] nums, int i, int j) {

        int a = nums[i];
        int b = nums[j];
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        nums[i] = a;
        nums[j] = b;
    }

    public static void main(String[] arg) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors2(nums);
        return;
    }
}
