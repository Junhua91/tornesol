package com.junhua.tornesol.algorithm.leetcode.strategie.search.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {


    static public List<List<Integer>> combine(int n, int k) {

        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = i;
        }

        int[] visited = new int[n + 1];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> out = new ArrayList<>();

        find(nums, visited, 0, res, out, k);
        return res;
    }

    static public void find(int[] nums, int[] visited, int level, List<List<Integer>> res, List<Integer> out, int k) {
        if (level == k) {
            res.add(new ArrayList<>(out));
            return;
        }

        for (int i = 1; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            if (level > 0 && out.get(level - 1) > nums[i]) continue;
            visited[i] = 1;
            out.add(nums[i]);
            find(nums, visited, level + 1, res, out, k);
            visited[i] = 0;
            int index = out.lastIndexOf(nums[i]);
            out.remove(index);
        }
    }


    static public List<List<Integer>> combine2(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        find2(n, k, 1, res, out);
        return res;
    }

    static public void find2(int n, int k, int level, List<List<Integer>> res, List<Integer> out) {
        if (out.size() == k) {
            res.add(new ArrayList<>(out));
        }
        for (int i = level; i <= n; i++) {
            out.add(i);
            find2(n, k, i + 1, res, out);
            int index = out.lastIndexOf(i);
            out.remove(index);
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> res = combine(4, 2);
        List<List<Integer>> res2 = combine2(4, 2);
        return;

    }
}
