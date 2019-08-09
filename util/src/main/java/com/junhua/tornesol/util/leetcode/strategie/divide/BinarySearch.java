package com.junhua.tornesol.util.leetcode.strategie.divide;

public class BinarySearch {

    /**
     * 排序，无重复数字
     *
     * @param nums
     * @param k
     * @return
     */
    public static int bs1(int[] nums, int k) {

        int start = 0;
        int end = nums.length;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == k) return mid;
            else if (nums[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 排序有重复数字，取出index最小的
     *
     * @param nums
     * @param k
     */
    public static int bs2(int[] nums, int k) {
        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= k) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 2, 2, 4,4, 5,7,9};
        System.out.println(bs1(nums, 3));
        System.out.println(bs2(nums2, 2));

    }
}
