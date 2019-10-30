package com.junhua.algorithm.sort.quick;

import com.junhua.algorithm.sort.SortUtils;
import com.junhua.algorithm.comparator.ComparatorUtils;

import java.util.Arrays;


/**
 * 1.时间复杂度：O(n log(n))，空间复杂度log(n)
 * 2.相比归并排序，常数项时间少，性能更优
 * 3. {5、4、3、2、1}  类型的数组, 经典的快排（取最后一个数做partition）时间复杂度为O(n^2)
 */
public class QuickSort {

    public static void quickSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        sort(nums, 0, nums.length - 1);
    }

    public static void sort(int[] nums, int L, int R) {
        if (L >= R) return;
        int[] p = partition(nums, L, R);
        sort(nums, 0, p[0]);
        sort(nums, p[1], R);
    }

    public static int[] partition(int[] nums, int L, int R) {
        //随机
        int num = nums[(int) Math.random() * (R - L + 1)];
        //固定取最后一位
        //int num = nums[R];
        int less = L - 1;
        int more = R;
        while (L <= more) {
            if (nums[L] < num) {
                SortUtils.swap(nums, ++less, L++);
            } else if (nums[L] > num) {
                SortUtils.swap(nums, L, more--);
            } else L++;
        }
        int[] res = new int[]{less, more};
        return res;
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 50000; i++) {
            int[] nums = ComparatorUtils.generateRandomArray(10, 50);
            int[] nums1 = ComparatorUtils.copyArray(nums);
            int[] nums2 = ComparatorUtils.copyArray(nums);
            quickSort(nums1);
            Arrays.sort(nums2);
            if (!ComparatorUtils.isEqual(nums1, nums2)) {
                ComparatorUtils.printArray(nums);
                throw new Exception("error");
            }
        }
        System.out.println("success");
    }

}
