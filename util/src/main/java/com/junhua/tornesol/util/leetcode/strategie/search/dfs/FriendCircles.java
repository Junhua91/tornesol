package com.junhua.tornesol.util.leetcode.strategie.search.dfs;

public class FriendCircles {

    static public int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static public int findCircleNum(int[][] M) {

        if (M.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 0) continue;
                res++;
                find(M, i, j);
            }
        }
        return res;
    }

    static public void find(int[][] M, int i, int j) {
        int nbRows = M.length;
        int nbCols = M[0].length;
        if (i < 0 || j < 0 || i >= nbRows || j >= nbCols || M[i][j] == 0) {
            return;
        }
        M[i][j] = 0;
        for (int[] xy : direction) {
            find(M, i + xy[0], j + xy[1]);
        }
    }

    public static void main(String[] args) {
        int[][] M = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };

        System.out.println(findCircleNum(M));
    }
}
