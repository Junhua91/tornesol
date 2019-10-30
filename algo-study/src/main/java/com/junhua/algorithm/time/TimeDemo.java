package com.junhua.algorithm.time;


import com.junhua.algorithm.comparator.ComparatorUtils;

import java.util.Arrays;

/**
 * 有序数组A，无序数组B，打印B中所有不在A中的数
 */
public class TimeDemo {


    /**
     * 时间复杂度 O（n * m）:  未利用nums1 有序这一特点
     *
     * @param nums1
     * @param nums2
     */
    public static void print1(int[] nums1, int[] nums2) {
        for (int num2 : nums2) {
            boolean flag = false;
            for (int num1 : nums1) {
                if (num1 == num2) flag = true;
            }
            if (!flag) System.out.print(num2 + "、");
        }
        System.out.println();
    }

    /**
     * 采用二分法的方式在nums1中查找元素，降低时间复杂度
     * O(n * log m)
     *
     * @param nums1
     * @param nums2
     */
    public static void print2(int[] nums1, int[] nums2) {
        for (int num2 : nums2) {
            boolean flag = false;
            int l = 0;
            int r = nums1.length - 1;
            while (l < r) {
                int m = l + ((r - l) >> 1);
                if (nums1[m] > num2) {
                    r = m - 1;
                } else if (nums1[m] == num2) {
                    flag = true;
                    break;
                } else {
                    l = m + 1;
                }
            }
            if (!flag) System.out.print(num2 + "、");
        }
        System.out.println();
    }

    /**
     * 1. 外排法
     * 2. 时间复杂度：O(m*logm + (m+n))
     *
     * @param nums1
     * @param nums2
     */
    public static void print3(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        int l = 0, r = 0;
        while (l < nums1.length && r < nums2.length) {
            if (nums1[l] < nums2[r]) l++;
            else if (nums1[l] > nums2[r]) {
                System.out.print(nums2[r] + "、");
                r++;
            } else {
                r++;
                l++;
            }
        }
        while (r < nums2.length) {
            System.out.print(nums2[r++] + "、");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums1 = ComparatorUtils.generateRandomArray(10, 50);
        Arrays.sort(nums1);
        int[] nums2 = ComparatorUtils.generateRandomArray(10, 50);
        print1(nums1, nums2);
        print2(nums1, nums2);
        print3(nums1, nums2);
    }


}
