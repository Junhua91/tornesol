package com.junhua.algorithm.leetcode.datastructure.array;

public class ReshapeTheMatrix {


    static public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0) return null;
        int rowLen = nums.length;
        int colLen = nums[0].length;
        if (rowLen * colLen < r * c) return nums;

        int[][] matrix = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                int totalIndex = (i * c) + j;
                int rowIndex = (totalIndex) / colLen;
                int colIndex = (totalIndex) % colLen;
                matrix[i][j] = nums[rowIndex][colIndex];
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2}, {3, 4}};

        int[][] matrix = matrixReshape(nums, 1, 4);

        return;
    }
}
