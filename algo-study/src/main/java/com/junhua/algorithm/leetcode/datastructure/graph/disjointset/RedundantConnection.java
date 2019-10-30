package com.junhua.algorithm.leetcode.datastructure.graph.disjointset;

import java.util.Arrays;

public class RedundantConnection {

    private static int[] S;
    public static int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        S = new int[len + 1];
        Arrays.fill(S, -1);
        for (int[] edge : edges) {
            int u = find(edge[0]);
            int v = find(edge[1]);
            if (u == v) {
                return edge;
            }
            if (u > v) {
                S[u] = v;
            } else S[v] = u;
        }
        return new int[]{-1, -1};
    }

    public static int find(int x) {
        if (S[x] < 0) {
            return x;
        } else return find(S[x]);
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int[][] nums1 = {{1, 4}, {3, 4}, {1, 3}, {1, 2}, {4, 5}};
        int[][] nums2 = {{3,4},{1,2},{2,4},{3,5},{2,5}};
        int[] res = findRedundantConnection(nums);
        int[] res1 = findRedundantConnection(nums1);
        int[] res2 = findRedundantConnection(nums2);
        return;
    }
}
