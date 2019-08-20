package com.junhua.tornesol.leetcode.datastructure.array;

public class MaxChunksToMakeSorted {

    static public int maxChunksToSorted(int[] arr) {

        if (arr == null || arr.length == 0) return 0;

        int count = 0;
        int preMax = arr[0];

        for (int i = 0; i < arr.length ; i++) {
            preMax = Math.max(preMax, arr[i]);
            if (preMax == i) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1, 0};
        int[] nums2 = {2, 0, 1};
        int[] nums3 = {1, 0, 2, 3, 4};
        int[] nums4 = {1, 2, 0, 3};

        System.out.println(maxChunksToSorted(nums));
        System.out.println(maxChunksToSorted(nums2));
        System.out.println(maxChunksToSorted(nums3));
        System.out.println(maxChunksToSorted(nums4));
    }
}
