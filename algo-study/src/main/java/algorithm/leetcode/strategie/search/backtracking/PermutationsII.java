package algorithm.leetcode.strategie.search.backtracking;

import java.util.*;


/**
 * 1. 每个nums中的数字在全排列中只能使用一次=> 用visited来存储访问信息
 * 2.
 */
public class PermutationsII {

    static public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        find(nums, visited, res, out, 0);
        return res;
    }

    static public void find(int[] nums, int[] visited, List<List<Integer>> res, List<Integer> out, int index) {
        if (index >= nums.length) {
            res.add(new ArrayList<>(out));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) {
                System.out.println("level:" + index + "; i:" +i+"; nums:"+ nums[i]);
                continue;
            }
            visited[i] = 1;
            out.add(nums[i]);
            find(nums, visited, res, out, index + 1);
            int m = out.lastIndexOf(nums[i]);
            visited[i] = 0;
            out.remove(m);
        }
    }

    static public void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> res = permuteUnique(nums);
        return;
    }

}
