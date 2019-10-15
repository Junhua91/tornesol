package com.junhua.tornesol.algorithm.leetcode.strategie.search.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PerfectSquares {

    static public int numSquares(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        int[] mark = new int[n + 1];
        mark[n] = 1;
        queue.offer(n);
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int square : squares) {
                    int next = cur - square;
                    if (next == 0) return count;
                    if (next < 0) break;
                    if (next > 0) {
                        if (mark[next] == 0) {
                            mark[next] = 1;
                            queue.offer(next);
                        }
                    }
                }
            }
        }
        return n;
    }


    public static void main(String[] args) {
        int res = numSquares(7);
        int res2 = numSquares(9);
        int res3 = numSquares(12);
        int res4 = numSquares(13);
        return;
    }

    static private List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= n) {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }
}
