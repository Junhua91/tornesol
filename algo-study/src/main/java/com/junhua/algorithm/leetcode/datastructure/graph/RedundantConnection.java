package com.junhua.algorithm.leetcode.datastructure.graph;

/**
 *并查集视频讲解：https://www.youtube.com/watch?v=wU6udHRIkcc
 *
 * 并查集可用来判断一个graph中是否有环，并且能知道是哪个edge构成了环
 */
public class RedundantConnection {


    public static int[] s;
    public static int[] findRedundantConnection(int[][] edges) {
        s = new int[edges.length + 1];
        //全部初始化为-1
        for (int i = 1; i <= edges.length; i++) {
            s[i] = -1;
        }
        //遍历所有的edge，如果edge里面的两个节点能找到同样的父节点，则表明有环；
        //如果没有相同的父节点，就将edge合并（将节点串在一起: 父节点大的指向父节点小的）
        for (int[] edge : edges) {
            int u = find(edge[0]);
            int v = find(edge[1]);
            //edge的两个node的父节点一样，表明构成了一个环
            if (u == v) {
                return edge;
            } else if (u > v) {
                s[u] = v;
            } else s[v] =u;
        }
        return new int[]{-1, -1};
    }

    /**
     * 递归查找到最上层的父节点
     *
     * @param x
     * @return
     */
    public static int find(int x) {
        if (s[x] < 0) return x;
        else return find(s[x]);
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
