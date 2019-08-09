package com.junhua.tornesol.util.leetcode.strategie.search.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> out = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        find(candidates, target, out, res, 0);
        return res;
    }

    public static void find(int[] candidates, int target, List<Integer> out, List<List<Integer>> res, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(out));
            return;
        }
        if (target < 0) return;
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) continue;
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            out.add(candidates[i]);
            find(candidates, target - candidates[i], out, res, i + 1);
            out.remove(out.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> res = combinationSum2(nums, 8);
        return;
    }
}
