package com.junhua.tornesol.util.leetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMax {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> indexQueue = new ArrayDeque<>();
        int length = nums.length;
        int[] result = new int[length - 2];

        for (int i = 0; i < nums.length; i++) {

            if (!indexQueue.isEmpty() && indexQueue.peek() < i - k + 1) {
                indexQueue.poll();
            }

            while (!indexQueue.isEmpty() && nums[indexQueue.peekLast()] < nums[i]) {
                indexQueue.pollLast();
            }

            indexQueue.offer(i);


            if (i >= k-1) {
                result[i-k+1] = nums[indexQueue.peek()];
            }

        }

        return result;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        for (int n : maxSlidingWindow(nums, 3)) {
            System.out.println(n);
        }
    }

}
