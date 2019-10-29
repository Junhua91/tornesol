package algorithm.leetcode.strategie.search.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    static public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        Arrays.sort(nums);
        int[] visited = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            find(nums, res, out, visited, i + 1, 0);
        }
        res.add(new ArrayList<>());
        return res;

    }

    static public void find(int[] nums, List<List<Integer>> res, List<Integer> out, int[] visited, int k, int start) {
        if (k == 0) {
            res.add(new ArrayList<>(out));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) continue;
            out.add(nums[i]);
            visited[i] = 1;
            find(nums, res, out, visited, k - 1, i + 1);
            out.remove(out.size() - 1);
            visited[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = subsetsWithDup(nums);
        return;
    }
}
