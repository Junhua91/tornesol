package com.junhua.tornesol.algorithm.leetcode.strategie.search.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    static public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }
        List<List<String>> res = new ArrayList<>();
        find(board, 0, n, res);
        return null;
    }


    public static void find(char[][] board, int i, int n, List<List<String>> res) {
        if (i == n) {
            List<String> list = new ArrayList<>();
            for (int m = 0; m < board.length; m++) {
                list.add(new String(board[m]));
            }
            res.add(list);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(board, i, col)) {
                board[i][col] = 'Q';
                find(board, i + 1, n, res);
                board[i][col] = '.';
            }
        }
    }

    /**
     * 从上往下放置Q
     * 每一行只能放置一个Q，于是不需要横向比较Q
     *
     * @param board
     * @param i
     * @param j
     * @return
     */
    public static boolean isValid(char[][] board, int i, int j) {
        int nbCols = board[0].length;
        //纵向比较: 往上比较
        for (int row = 0; row < i; row++) {
            if (board[row][j] == 'Q') return false;
        }
        //左->右 对角线
        for (int m = i - 1, n = j - 1; m >= 0 && n >= 0; m--, n--) {
            if (board[m][n] == 'Q') return false;
        }
        //右->左 对角线
        for (int m = i - 1, n = j + 1; m >= 0 && n < nbCols; m--, n++) {
            if (board[m][n] == 'Q') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'.', 'Q', '.', '.'},
                {'.', '.', '.', 'Q'},
                {'Q', '.', '.', '.'},
                {'.', '.', 'Q', '.'}
        };

        solveNQueens(4);
    }
}

