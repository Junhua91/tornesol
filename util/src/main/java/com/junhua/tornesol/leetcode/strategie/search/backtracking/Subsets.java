package com.junhua.tornesol.leetcode.strategie.search.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {


    static public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            find(nums, res, out, i + 1, 0);
        }
        res.add(new ArrayList<>());
        return res;

    }

    static public void find(int[] nums, List<List<Integer>> res, List<Integer> out, int k, int start) {
        if (k == 0) {
            res.add(new ArrayList<>(out));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            out.add(nums[i]);
            find(nums, res, out, k - 1, i + 1);
            out.remove(out.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = subsets(nums);
        return;
    }
}
