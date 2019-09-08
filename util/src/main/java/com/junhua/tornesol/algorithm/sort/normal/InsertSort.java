package com.junhua.tornesol.algorithm.sort.normal;


import com.junhua.tornesol.algorithm.comparator.ComparatorUtils;

import java.util.Arrays;

/**
 * 1. 将一个数据插入到已经排好序的有序数据中
 * 2. 时间复杂度O(n^2)
 * 3. 常数的操作相比冒泡排序要少点
 */
public class InsertSort {

    public static int[] insertSort(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (temp < nums[j]) {
                    nums[j + 1] = nums[j];
                } else break;
            }
            nums[j + 1] = temp;
        }
        return nums;
    }

    public static void insertSortReview(int[] nums) {
        if (nums == null || nums.length < 2) return;
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > tmp) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = tmp;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            int[] randomNums = ComparatorUtils.generateRandomArray(50, 100);
            int[] newNums1 = ComparatorUtils.copyArray(randomNums);
            int[] newNums2 = ComparatorUtils.copyArray(randomNums);
            Arrays.sort(newNums1);
            insertSortReview(newNums2);
            if (!ComparatorUtils.isEqual(newNums1, newNums2)) {
                System.out.println("error");
                ComparatorUtils.printArray(randomNums);
                break;
            }
        }
    }
}
