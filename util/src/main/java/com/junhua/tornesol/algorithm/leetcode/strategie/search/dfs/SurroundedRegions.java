package com.junhua.tornesol.algorithm.leetcode.strategie.search.dfs;

public class SurroundedRegions {

    static public int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static public void solve(char[][] board) {

        if (board.length == 0) return;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
                    find(board, i, j);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    static public void find(char[][] board, int i, int j) {
        int nbRows = board.length;
        int nbCols = board[0].length;
        if (i < 0 || i >= nbRows || j < 0 || j >= nbCols || board[i][j] != 'O' ) return;
        if (board[i][j] == 'O') {
            board[i][j] = 'T';
        }
        for (int[] xy : direction) {
            find(board, i + xy[0], j + xy[1]);
        }
    }

    public static void main(String[] args) {

        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X'}
        };
        solve(board);
        return;
    }

}
