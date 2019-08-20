package com.junhua.tornesol.leetcode.strategie.search.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {


    static public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> out = new ArrayList<>(k);
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        find(nums, out, res, 0, k, n);
        return res;
    }

    public static void find(int[] nums, List<Integer> out, List<List<Integer>> res, int start, int k, int target) {
        if (k == 0 & target == 0) {
            res.add(new ArrayList<>(out));
            return;
        }
        if (k <= 0) return;
        for (int i = start; i < nums.length; i++) {
            if (target < nums[i]) continue;
            out.add(nums[i]);
            find(nums, out, res, i + 1, k - 1, target - nums[i]);
            out.remove(out.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = combinationSum3(3, 7);
        List<List<Integer>> res2 = combinationSum3(3, 9);
        return;
    }
}
