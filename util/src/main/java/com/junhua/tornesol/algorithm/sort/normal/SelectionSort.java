package com.junhua.tornesol.algorithm.sort.normal;

import com.junhua.tornesol.algorithm.comparator.ComparatorUtils;
import com.junhua.tornesol.algorithm.sort.SortUtils;

import java.util.Arrays;


/**
 * 1. 时间复杂度：O（n^2），额外空间复杂度: O(1)
 * 2. 非稳定： 5(a)、8、5(b)、2、9=> 2、5b、5a、8、9
 */
public class SelectionSort {

    static public int[] selectSort(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                minIndex = (nums[j] < nums[minIndex]) ? j : minIndex;
            }
            SortUtils.swap(nums, i, minIndex);
        }
        return nums;
    }

    /**
     * m每次找出一个最小的数替换
     *
     * @param nums
     */
    public static void selectionReview(int[] nums) {
        if (nums == null || nums.length < 2) return;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    SortUtils.swap(nums, i, j);
                }
            }
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            int[] randomNums = ComparatorUtils.generateRandomArray(50, 100);
            int[] newNums1 = ComparatorUtils.copyArray(randomNums);
            int[] newNums2 = ComparatorUtils.copyArray(randomNums);
            Arrays.sort(newNums1);
            selectionReview(newNums2);
            if (!ComparatorUtils.isEqual(newNums1, newNums2)) {
                System.out.println("error");
                ComparatorUtils.printArray(randomNums);
                break;
            }
        }
        System.out.println("success");
    }

}
