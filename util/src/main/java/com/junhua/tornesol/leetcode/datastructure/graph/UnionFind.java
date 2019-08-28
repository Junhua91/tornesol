package com.junhua.tornesol.leetcode.datastructure.graph;


/**
 * 1. Union find 模版:需要牢记
 * 2. 该模版只会统计"块"的个数，并没有考虑对称的情况
 *
 */
public class UnionFind {
    //统计圈子的个数
    private int count;
    //记录各个node的parent信息
    private int[] parent;
    //统计圈子下的node数量
    private int[] rank;
    //n: node 的数量
    public UnionFind(int M) {
        this.count = M;
        parent = new int[M];
        rank = new int[M];
    }
    //找到根节点
    public int find(int p) {
        if (parent[p] == 0) {
            return p;
        } else return find(parent[p]);
    }
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        if (rank[rootP] > rank[rootQ]) {
            parent[rootQ] = rootP;
        } else {
            parent[rootP] = rootQ;
            if (rank[rootP] == rank[rootQ]) {
                rank[rootP]++;
            }
        }
        count--;
    }
    public int getCount() {
        return count;
    }
}