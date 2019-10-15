package com.junhua.tornesol.algorithm.leetcode.datastructure.array;

public class ToeplitzMatrix {

    static public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return true;
        int nbCol = matrix[0].length;
        int nbRow = matrix.length;
        for (int i = 0; i < nbCol; i++) {
            if (!find(matrix, matrix[0][i], 0, i))
                return false;
        }
        for (int i = 0; i < nbRow; i++) {
            if (!find(matrix, matrix[i][0], i, 0))
                return false;
        }
        return true;
    }

    public static boolean find(int[][] matrix, int expectValue, int row, int col) {
        if (row >= matrix.length || col >= matrix[0].length)
            return true;

        if (matrix[row][col] != expectValue) return false;
        return find(matrix, expectValue, row + 1, col + 1);
    }


    static public boolean isToeplitzMatrix2(int[][] matrix) {
        int nbCol = matrix[0].length;
        int nbRow = matrix.length;
        for (int i = 0; i < nbRow - 1; i++) {
            for (int j = 0; j < nbCol - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}
        };

        System.out.println(isToeplitzMatrix2(matrix));
    }
}
