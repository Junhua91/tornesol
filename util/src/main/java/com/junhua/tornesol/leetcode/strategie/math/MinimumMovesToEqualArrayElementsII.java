package com.junhua.tornesol.leetcode.strategie.math;


import java.util.Arrays;

/**
 * 将所有的数移动到中位数
 */
public class MinimumMovesToEqualArrayElementsII {

    static public int minMoves2(int[] nums) {
        int res = 0;
        int n = nums.length;
        Arrays.sort(nums);

        int i = 0, j = n - 1;
        while (i <= j) {
            res += (nums[j--] - nums[i++]);
        }
        return res;
    }


    static public int minMoves22(int[] nums) {
        int res = 0;
        int midNum = findKthSmallest(nums, nums.length / 2);
        for (int i = 0; i < nums.length; i++) {
            res += Math.abs(nums[i] - midNum);
        }
        return res;
    }


    /**
     * 找数组的中位数
     *
     * @param elements
     * @param start
     * @param end
     * @return
     */
    private static int getPivotByPartition(int[] elements, int start, int end) {
        int pivot = elements[start];
        int index = start;
        for (int i = start; i <= end; i++) {
            if (elements[i] < pivot) {
                index++;
                int temp = elements[i];
                elements[i] = elements[index];
                elements[index] = temp;
            }
        }
        elements[start] = elements[index];
        elements[index] = pivot;
        return index;
    }

    private static int findKthSmallest(int[] elements, int k) {

        int l = 0, h = elements.length - 1;
        while (l < h) {
            int index = getPivotByPartition(elements, l, h);
            if (index == k) {
                break;
            }
            if (index > k) {
                h = index - 1;
            } else {
                l = index + 1;
            }
        }
        return elements[k];
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 8, 6};

        System.out.println(minMoves2(nums));
        System.out.println(minMoves22(nums));
    }
}
