package com.junhua.tornesol.algorithm.leetcode.strategie.sort;


/**
 * 最佳情况：T(n) = O(n)
 * 最差情况：T(n) = O(n2)
 * 平均情况：T(n) = O(n2)
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }

            }
        }
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
