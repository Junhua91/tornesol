package com.junhua.tornesol.algorithm.leetcode.strategie.search.backtracking;

public class SudokuSolver {

    static public void solveSudoku(char[][] board) {
        find(board, 0, 0);
    }

    /**
     * 先遍历行，再遍历列
     *
     * @param board
     * @param i
     * @param j
     * @return
     */
    public static boolean find(char[][] board, int i, int j) {
        if (i == 9) {
            return true;
        }
        if (j >= 9) {
            return find(board, i + 1, 0);
        }
        if (board[i][j] == '.') {
            for (int num = 1; num <= 9; num++) {
                board[i][j] = (char) (num + '0');
                if (isValid(board, i, j)) {
                    if (find(board, i, j + 1)) return true;
                }
                //如果未能找到，则回退回去
                board[i][j] = '.';
            }
        } else {
            return find(board, i, j + 1);
        }
        return false;
    }

    /**
     * bounding function
     *
     * @param board
     * @param i
     * @param j
     * @return
     */
    public static boolean isValid(char[][] board, int i, int j) {
        //判断行是否有相同值
        for (int col = 0; col < 9; col++) {
            if (col != j && board[i][col] == board[i][j]) return false;
        }
        //判断列是否有相同值
        for (int row = 0; row < 9; row++) {
            if (row != i && board[row][j] == board[i][j]) return false;
        }
        for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {
            for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++) {
                if ((row != i || col != j) && board[row][col] == board[i][j]) return false;
            }
        }


        return true;
    }

    public static void main(String[] args) {

        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        solveSudoku(board);
//        test(board);
        return;
    }

    public static void test(char[][] board) {

        for (int i = 0; i < 9; i++) {
            board[i][0] = '*';
        }

    }
}
