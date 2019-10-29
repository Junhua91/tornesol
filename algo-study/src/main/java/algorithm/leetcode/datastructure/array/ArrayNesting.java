package algorithm.leetcode.datastructure.array;

import java.util.HashMap;
import java.util.Map;

public class ArrayNesting {

    static public int arrayNesting(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int j = i;
            int count = 0;
            while (j <= nums.length - 1 && !map.containsKey(j)) {
                count++;
                map.put(j, 1);
                j = nums[j];
            }
            res = Math.max(res, count);
        }
        return res;
    }

    static public int arrayNesting2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            int count = 0;
            while (nums[j] != -1) {
                count++;
                nums[j] = -1;
                j = nums[j];
            }
            res = Math.max(res, count);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 0, 3, 1, 6, 2};
        System.out.println(arrayNesting(nums));
    }
}
