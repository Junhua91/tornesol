package com.junhua.algorithm.sort.merge;

import com.junhua.algorithm.comparator.ComparatorUtils;
import com.junhua.algorithm.sort.SortUtils;

import java.util.Arrays;

public class MergeSortReview {

    public static void mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        sort(nums, 0, nums.length - 1);
    }


    public static void sort(int[] nums, int L, int R) {
        if (L == R) return;
        int M = L + ((R - L) >> 1);
        sort(nums, L, M);
        sort(nums, M + 1, R);
        SortUtils.merge(nums, L, R);
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10000; i++) {
            int[] nums = ComparatorUtils.generateRandomArray(20, 50);
            int[] nums1 = ComparatorUtils.copyArray(nums);
            int[] nums2 = ComparatorUtils.copyArray(nums);
            mergeSort(nums1);
            Arrays.sort(nums2);
            if (!ComparatorUtils.isEqual(nums1, nums2)) {
                ComparatorUtils.printArray(nums);
                throw new Exception("error");
            }
        }
        System.out.println("success");
    }
}
