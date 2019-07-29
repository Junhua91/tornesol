package com.junhua.tornesol.util.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartiteII {

    static public boolean isBipartite(int[][] graph) {
        int lenght = graph.length;
        int[] color = new int[lenght];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < lenght; i++) {
            if (color[i] != 0) continue;
            if (color[i] == 0) {
                color[i] = 1;
                queue.offer(i);
            }
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int num : graph[cur]) {
                    if (color[num] == 0) {
                        color[num] = -color[cur];
                        queue.offer(num);
                    } else if (color[num] != -color[cur]) return false;
                }
            }
        }
        return true;
    }
}
