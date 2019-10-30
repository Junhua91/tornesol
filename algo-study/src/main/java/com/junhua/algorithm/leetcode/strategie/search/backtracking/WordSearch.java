package com.junhua.algorithm.leetcode.strategie.search.backtracking;

public class WordSearch {


    static public boolean exist(char[][] board, String word) {

        if (board.length == 0) return false;
        int nbRows = board.length;
        int nbCols = board[0].length;

        if (nbRows * nbCols < word.length()) return false;

        for (int i = 0; i < nbRows; i++) {
            for (int j = 0; j < nbCols; j++) {
                if (find(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    static public boolean find(char[][] board, int i, int j, String word, int level) {
        int nbRows = board.length;
        int nbCols = board[0].length;
        if (level == word.length()) return true;
        if (i < 0 || j < 0 || i >= nbRows || j >= nbCols || board[i][j] == '*' || word.charAt(level) != board[i][j])
            return false;
        char temp = board[i][j];
        board[i][j] = '*';
        boolean res = find(board, i + 1, j, word, level + 1) ||
                find(board, i - 1, j, word, level + 1) ||
                find(board, i, j + 1, word, level + 1) ||
                find(board, i, j - 1, word, level + 1);
        board[i][j] = temp;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        char[][] board2 = {{'a'}};

        char[][] board3 = {{'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}
        };

        System.out.println(exist(board, "ABCCED"));
//        System.out.println(exist(board, "SEE"));
//        System.out.println(exist(board, "ABCB"));
        System.out.println(exist(board2, "b"));
        System.out.println(exist(board3,"AAB"));
    }
}
