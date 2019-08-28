package com.junhua.tornesol.offer;

public class Nowcoder1 {

    static public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) return false;
        int m = array.length, n = array[0].length;
        int i = 0, j = n - 1;
        if (target > array[m - 1][n - 1] || target < array[0][0]) return false;
        while (i < m && j >= 0) {
            if (target == array[i][j]) return true;
            if (target > array[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
