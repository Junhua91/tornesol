package com.junhua.algorithm.sort.quick;

import com.junhua.algorithm.sort.SortUtils;

/**
 * 1. 小于target的数放在左边，taget放在中间，大于target的数放在右边
 * 2. 没有稳定性：并没有保证顺序
 */
public class Partition {

    public static int[] partition(int[] nums, int target) {
        int less = -1;
        int L = 0;
        int more = nums.length - 1;
        while (L <= more) {
            if (nums[L] > target) {
                SortUtils.swap(nums, L, more--);
            } else if (nums[L] < target) {
                SortUtils.swap(nums, ++less, L++);
            } else L++;
        }
        return new int[]{less + 1, more};
    }

    public static void partitionReview(int[] nums, int target) {
        if (nums == null || nums.length < 2) return;
        int LESS = -1;
        int CUR = 0;
        int MORE = nums.length - 1;

        while (CUR < MORE) {
            if (nums[CUR] < target) {
                SortUtils.swap(nums, ++LESS, CUR++);
            } else if (nums[CUR] > target) {
                SortUtils.swap(nums, CUR, MORE--);
            } else {
                CUR++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {-8, -37, -14, 19, 0, 22, -16, 20, 0, 0};
        int[] nums2 = {-8, -37, -14, 19, 0, 22, -16, 20, 0, 0};
        int[] res = partition(nums, 0);
        partitionReview(nums2, 0);
        return;
    }


}
