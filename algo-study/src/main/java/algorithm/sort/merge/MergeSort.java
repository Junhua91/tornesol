package algorithm.sort.merge;


import com.junhua.algorithm.comparator.ComparatorUtils;

import java.util.Arrays;

/**
 * 归并排序
 * 1. master公式：2*T(n/2) + O(n) => O(n*log n)
 */
public class MergeSort {

    public static void mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        sort(nums, 0, nums.length - 1);
    }

    public static void sort(int[] nums, int start, int end) {
        if (start == end) return;
        int mid = start + ((end - start) >> 1);
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    public static void merge(int[] nums, int L, int mid, int R) {
        int[] res = new int[R - L + 1];
        int pLeft = L;
        int pRight = mid + 1;
        int i = 0;
        while (pLeft <= mid && pRight <= R) res[i++] = (nums[pLeft] > nums[pRight]) ? nums[pRight++] : nums[pLeft++];
        while (pLeft <= mid) res[i++] = nums[pLeft++];
        while (pRight <= R) res[i++] = nums[pRight++];
        for (int m = 0; m < res.length; m++) nums[L + m] = res[m];

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
