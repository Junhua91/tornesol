package com.junhua.tornesol.util.leetcode;

import java.util.*;

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

        for (List<Integer> list:threeSum(nums)){
            for(int i:list){
                System.out.print(i+",");
            }
            System.out.println();
        }

    }
}
