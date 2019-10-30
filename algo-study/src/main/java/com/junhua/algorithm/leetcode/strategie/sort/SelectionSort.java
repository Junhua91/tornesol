package com.junhua.algorithm.leetcode.strategie.sort;


/**
 * 最佳情况：T(n) = O(n2)
 * 最差情况：T(n) = O(n2)
 * 平均情况：T(n) = O(n2)
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int index = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    index = j;
                }
            }
            int temp = nums[i];
            nums[i] = min;
            nums[index] = temp;
        }

        for (int i : nums) {
            System.out.println(i);
        }
    }
}
