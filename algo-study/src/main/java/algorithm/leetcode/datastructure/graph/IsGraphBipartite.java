package algorithm.leetcode.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {

    static public boolean isBipartite(int[][] graph) {
        int length = graph.length;
        int[] colors = new int[length];
        for (int i = 0; i < length; i++) {
            if (colors[i] == 0 && !find(graph, colors, 1, i)) return false;
        }
        return true;
    }

    static public boolean find(int[][] graph, int[] colors, int color, int node) {
        if (color != 0) return colors[node] == color;
        colors[node] = color;
        for (int n : graph[node]) {
            if (!find(graph, colors, -color, n)) return false;
        }
        return true;
    }

    static public boolean isBipartite2(int[][] graph) {
        int length = graph.length;
        int[] colors = new int[length];
        for (int i = 0; i < length; i++) {
            if (colors[i] != 0) continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            colors[i] = 1;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int node : graph[cur]) {
                    if (colors[node] == 0) {
                        colors[node] = -colors[cur];
                        queue.offer(node);
                    } else if (colors[cur] != -colors[node]) return false;

                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[][] graph2 = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        int[][] graph1 = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};

        System.out.println(isBipartite(graph1));
        System.out.println(isBipartite2(graph1));

    }
}
