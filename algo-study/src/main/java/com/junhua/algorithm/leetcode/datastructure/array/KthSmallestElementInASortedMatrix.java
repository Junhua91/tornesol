package com.junhua.algorithm.leetcode.datastructure.array;

import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {


    static public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        int rowIndex = matrix.length - 1;
        int colIndex = matrix[0].length - 1;
        for (int i = 0; i <= colIndex; i++) {
            pq.offer(new Tuple(0, i, matrix[0][i]));
        }
        for (int i = 0; i < k - 1; i++) {
            Tuple t = pq.poll();
            if (t.x == rowIndex) continue;
            pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }

        return pq.poll().val;
    }

    static class Tuple implements Comparable<Tuple> {
        int x, y, val;

        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple that) {
            return this.val - that.val;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };

        System.out.println(kthSmallest(matrix, 8));

    }
}
