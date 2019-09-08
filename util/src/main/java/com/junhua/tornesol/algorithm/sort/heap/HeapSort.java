package com.junhua.tornesol.algorithm.sort.heap;


import com.junhua.tornesol.algorithm.comparator.ComparatorUtils;
import com.junhua.tornesol.algorithm.sort.SortUtils;

import java.util.Arrays;

public class HeapSort {

    public static void heapSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        for (int i = 0; i < nums.length; i++) {
            heapInsert(nums, i);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            SortUtils.swap(nums, 0, i);
            hepify(nums, 0, i);
        }
    }

    /**
     * @param nums
     * @param index
     */
    public static void heapInsert(int[] nums, int index) {
        while (nums[index] > nums[(index - 1) / 2]) {
            SortUtils.swap(nums, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * @param nums
     * @param index:       开始调整的位置
     * @param heapSize：堆长度
     */
    public static void hepify(int[] nums, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int largest = (left + 1) < heapSize && (nums[left] < nums[left + 1]) ? left + 1 : left;
            largest = nums[index] < nums[largest] ? largest : index;
            if (index == largest) break;
            SortUtils.swap(nums, index, largest);
            index = largest;
            left = 2 * index + 1;
        }

    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10000; i++) {
            int[] nums = ComparatorUtils.generateRandomArray(20, 50);
            int[] nums1 = ComparatorUtils.copyArray(nums);
            int[] nums2 = ComparatorUtils.copyArray(nums);
            heapSort(nums1);
            Arrays.sort(nums2);
            if (!ComparatorUtils.isEqual(nums1, nums2)) {
                ComparatorUtils.printArray(nums);
                throw new Exception("error");
            }
        }
        System.out.println("success");
    }


}
