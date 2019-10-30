package com.junhua.algorithm.leetcode.strategie.search.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {


    static public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        find(candidates, target, out, res, 0);
        return res;
    }

    public static void find(int[] candidates, int target, List<Integer> out, List<List<Integer>> res, int index) {
        if (0 == target) {
            res.add(new ArrayList<>(out));
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] > target) continue;
            if (index > 0 && out.get(index - 1) > candidates[i]) continue;
            out.add(candidates[i]);
            find(candidates, target - candidates[i], out, res, index + 1);
            out.remove(out.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] sum = {2, 3, 6, 7};
        int[]sum2 = {2,3,5};
        List<List<Integer>> res = combinationSum(sum, 7);
        List<List<Integer>> res2= combinationSum(sum2, 8);
        return;
    }
}
