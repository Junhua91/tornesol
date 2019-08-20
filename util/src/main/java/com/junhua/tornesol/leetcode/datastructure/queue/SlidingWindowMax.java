package com.junhua.tornesol.leetcode.datastructure.queue;

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


            if (i >= k - 1) {
                result[i - k + 1] = nums[indexQueue.peek()];
            }

        }

        return result;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        for (int n : maxSlidingWindow2(nums, 3)) {
            System.out.println(n);

        }

//        Deque<Integer>deque = new ArrayDeque<>();
//
//        for(int num:nums){
//            deque.offer(num);
//        }
//
//        System.out.println(deque.peek());
//        System.out.println(deque.peekLast());
    }

    public static int[] maxSlidingWindow2(int[] nums, int k) {

        if (nums == null || nums.length == 0) return null;

        Deque<Integer> deque = new ArrayDeque<>();

        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {

            if (!deque.isEmpty() && i - deque.peek() > k-1) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peek()];

            }
        }

        return res;
    }
}