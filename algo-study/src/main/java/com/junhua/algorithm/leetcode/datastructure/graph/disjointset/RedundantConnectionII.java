package com.junhua.algorithm.leetcode.datastructure.graph.disjointset;

public class RedundantConnectionII {

    private static int[] S;

    static public int[] findRedundantDirectedConnection(int[][] edges) {
        S = new int[edges.length + 1];
        int[] first = new int[2], secode = new int[2];
        for (int[] edge : edges) {
            int v = S[edge[1]];
            if (v == 0) {
                S[edge[1]] = edge[0];
            } else {
                first[0] = S[edge[1]];
                first[1] = edge[1];
                secode = edge;
                edge[1] = 0;
            }
        }
        for (int[] edge : edges) {
            int u = findRoot(edge[0]);
            int v = findRoot(edge[1]);

            if (u == v) {
                if (first[0] == 0 && first[1] == 0) {
                    return edge;
                } else {
                    return first;
                }
            }
        }
        return secode;
    }

    public static int findRoot(int x) {
        if (S[x] == 0) return x;
        return findRoot(S[x]);
    }

    public static void main(String[] args) {
        int[][] nums2 = {{2, 1}, {3, 1}, {4, 2}, {1, 4}};
        int[] res2 = findRedundantDirectedConnection(nums2);
        return;
    }
}
