package com.junhua.tornesol.util.leetcode.datastructure.array;

public class FindDuplicateNumber {


    static public int findDuplicate2(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int[] count = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
            if (count[nums[i]] == 2) return nums[i];
        }

        return 0;
    }

    static public int findDuplicate(int[] nums) {

        int low = 1, high = nums.length - 1;
        while (low <= high) {
            int mid = (int) (low + (high - low) * 0.5);
            int cnt = 0;
            for (int a : nums) {
                if (a <= mid) ++cnt;
            }
            if (cnt <= mid) low = mid + 1;
            else high = mid - 1;
        }
        return low;

    }


    static public int findDuplicate3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int low = 1;
        int high = nums.length;
        while (low <= high) {
            int count = 0;
            int mid = (high - low) / 2 + low;
            for (int num : nums) {
                if (num <= mid) count++;
            }
            if (count <= mid) {
                low = mid + 1;
            } else high = mid - 1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,3,4,2};
        System.out.println(findDuplicate3(nums));
        System.out.println(findDuplicate(nums));
    }
}
