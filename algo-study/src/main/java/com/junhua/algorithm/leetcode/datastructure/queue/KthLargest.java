package com.junhua.algorithm.leetcode.datastructure.queue;

import java.util.PriorityQueue;

public class KthLargest {

    private PriorityQueue<Integer> kthLargestQueue = new PriorityQueue();
    private int kth;

    public KthLargest(int k, int[] nums) {
        kth = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {

        if (kth > kthLargestQueue.size()) {
            kthLargestQueue.add(val);
        } else if (val > kthLargestQueue.peek()) {
            kthLargestQueue.remove();
            kthLargestQueue.add(val);
        }
        return kthLargestQueue.peek();
    }


    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{2, 4, 6, 8, 9, 80});
        System.out.println(kthLargest.add(100));
    }

}
