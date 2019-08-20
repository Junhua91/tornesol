package com.junhua.tornesol.leetcode.strategie.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthElement {

    static public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (k > 0) {
                queue.offer(nums[i]);
                k--;
            } else {
                int node = queue.peek();
                if (nums[i] > node) {
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }
        return queue.peek();
    }

    static public int findKthLargest2(int[] nums, int k) {
        return select(nums, k, 0, nums.length - 1);
    }


    static public int select(int[] nums, int k, int start, int end) {

        int pivotIndex = partition(nums, start, end);

        if (k == (pivotIndex - start + 1)) {
            return nums[pivotIndex];
        } else if (k < pivotIndex - start + 1) {
            return select(nums, k, start, pivotIndex - 1);
        } else {
            return select(nums, k - (pivotIndex - start + 1), pivotIndex + 1, end);
        }
    }


    static public int partition(int[] elements, int start, int end) {
        int pivot = elements[start];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (elements[i] >= pivot) {
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

    static public int findKthLargest3(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(nums, 4));
        System.out.println(findKthLargest2(nums, 4));
        System.out.println(findKthLargest3(nums, 4));


//        System.out.println(partition(nums, 0, nums.length - 1));
    }


}
