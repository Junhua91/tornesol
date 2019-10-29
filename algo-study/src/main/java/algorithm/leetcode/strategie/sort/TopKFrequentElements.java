package algorithm.leetcode.strategie.sort;

import java.util.*;


/**
 * 桶排序：
 * 1. map 计数
 * 2. 将计数的结果存放在Array中（count为index， value为值）
 * 3. 从后向前向Array中取k个数
 */
public class TopKFrequentElements {

    static public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numCount = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }
        ArrayList[] list = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
            //用计数来作为key
            int index = entry.getValue();
            if (list[index] == null) {
                list[index] = new ArrayList();
            }
            list[index].add(entry.getKey());
        }
        for (int i = list.length - 1; i >= 0 && k > 0; i--) {
            if (list[i] == null) continue;
            if (k > list[i].size()) {
                res.addAll(list[i]);
                k = k - list[i].size();
            } else {
                res.addAll(list[i].subList(0, k));
                k = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};

        List<Integer> res = topKFrequent(nums, 2);
        return;

    }
}
