package com.junhua.tornesol.leetcode.strategie.divide;

public class SingleElementInSortedArray {

    static public int singleNonDuplicate(int[] nums) {

        int l = 0;
        int h = nums.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if ((mid & 1) == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    l = mid + 2;
                } else  {
                    h = mid;
                }
            } else {
                if (nums[mid] == nums[mid + 1]) {
                    h = mid;
                } else{
                    l = mid + 1;
                }
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3};
        int[] nums2 = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int[] nums3 = {3, 3, 7, 7, 10, 11, 11};
        int[] nums4 = {1};

        System.out.println(singleNonDuplicate(nums));
        System.out.println(singleNonDuplicate(nums2));
        System.out.println(singleNonDuplicate(nums3));
        System.out.println(singleNonDuplicate(nums4));

    }
}
