package com.junhua.tornesol.util.leetcode.graph;

import java.util.Arrays;

public class IsGraphBipartite {

    static public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for (int i = 0; i < graph.length; i++) {  // 处理图不是连通的情况
            if (colors[i] == -1 && !isBipartite(i, 0, colors, graph)) {
                return false;
            }
        }
        return true;
    }

    static private boolean isBipartite(int curNode, int curColor, int[] colors, int[][] graph) {
        if (colors[curNode] != -1) {
            return colors[curNode] == curColor;
        }
        colors[curNode] = curColor;
        for (int nextNode : graph[curNode]) {
            if (!isBipartite(nextNode, 1 - curColor, colors, graph)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[][] graph2 = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        int[][] graph1 = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};

        System.out.println(isBipartite(graph1));
//        System.out.println(isBipartite(graph1));

    }
}
