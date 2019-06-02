package com.junhua.tornesol.util.leetcode;

import java.util.*;

/**
 * 解法1：双重循坏 + set判断
 * 解法2：排序 + 头尾双向移动
 */
public class ThreeSum {

    static public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> numSet = new HashSet<>();
        for (int i : nums) {
            numSet.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum2 = nums[i] + nums[j];
                if (numSet.contains(-sum2)) {
                    result.add(Arrays.asList(nums[i], nums[j], -sum2));
                }
            }
        }
        return result;
    }

    static public void main(String[] args) {

        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

        for (List<Integer> list : threeSum(nums)) {
            for (int i : list) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
        System.out.println("*********");


        List<List<Integer>> result = new ArrayList<>();
        int[] numsOrdered = new int[]{-4, -1, -1, 0, 1, 2};
        for (int i = 0; i < numsOrdered.length; i++) {
            int startIndex = i + 1;
            int endIndex = numsOrdered.length - 1;
            while (startIndex < endIndex) {
                int sum = numsOrdered[i] + numsOrdered[startIndex] + numsOrdered[endIndex];
                if (sum == 0) {
                    result.add(Arrays.asList(numsOrdered[i], numsOrdered[startIndex], numsOrdered[endIndex]));
                    break;
                } else if (sum > 0) {
                    endIndex -= 1;
                } else {
                    startIndex += 1;
                }
            }
        }

        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }


}
