package com.junhua.tornesol.leetcode.strategie.search.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PacificAtlanticWaterFlow {

    static public int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


    static public List<List<Integer>> pacificAtlantic(int[][] matrix) {


        if (matrix.length == 0) return Collections.emptyList();

        int nbRows = matrix.length;
        int nbCols = matrix[0].length;
        int[][] visited = new int[nbRows][nbCols];

        List<List<Integer>> res = new ArrayList<>();

        int[][] pacific = new int[nbRows][nbCols];
        int[][] atlantic = new int[nbRows][nbCols];


        for (int i = 0; i < nbRows; i++) {
            find(matrix, i, 0, -1, pacific);
            find(matrix, i, nbCols - 1, -1, atlantic);
        }

        for (int i = 0; i < nbCols; i++) {
            find(matrix, 0, i, -1, pacific);
            find(matrix, nbRows - 1, i, -1, atlantic);
        }

        for (int i = 0; i < nbRows; i++) {
            for (int j = 0; j < nbCols; j++) {
                if (pacific[i][j] == atlantic[i][j] && pacific[i][j] == 1) {
                    List<Integer> valid = Arrays.asList(i, j);
                    res.add(valid);
                }
            }
        }
        return res;
    }

    static public void find(int[][] matrix, int i, int j, int pre, int[][] visited) {
        int nbRows = matrix.length;
        int nbCols = matrix[0].length;
        if (i < 0 || j < 0 || i >= nbRows || j >= nbCols || matrix[i][j] < pre || visited[i][j] == 1)
            return;
        visited[i][j] = 1;
        for (int[] xy : direction) {
            find(matrix, i + xy[0], j + xy[1], matrix[i][j], visited);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        List<List<Integer>> res = pacificAtlantic(matrix);
        return;

    }
}
