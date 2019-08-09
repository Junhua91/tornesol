package com.junhua.tornesol.util.leetcode.strategie.search.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {

    static public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0) return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        find(nums, list, res, 0);
        return res;
    }

    public static void find(int[] nums, List<Integer> list, List<List<Integer>> res, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            find(nums, list, res, index + 1);
            int m = list.indexOf(nums[i]);
            list.remove(m);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = permute(nums);
        return;
    }
}
