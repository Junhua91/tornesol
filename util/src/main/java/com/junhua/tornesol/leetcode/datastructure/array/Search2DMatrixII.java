package com.junhua.tornesol.leetcode.datastructure.array;

public class Search2DMatrixII {


    static public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rowLen = matrix.length - 1;
        int colLen = matrix[0].length - 1;
        if (target > matrix[rowLen][colLen] || target < matrix[0][0]) return false;
        int i = 0;
        int j = colLen;
        while (i <= rowLen && j >= 0) {

            if (target == matrix[i][j]) return true;

            else if (target < matrix[i][j]) j--;
            else i++;
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        int[][] matrix2 = {{-1, 3}};

        System.out.println(searchMatrix(matrix, 13));
        System.out.println(searchMatrix(matrix2, 3));
    }
}
