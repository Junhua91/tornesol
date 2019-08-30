package com.junhua.tornesol.offer;

import java.util.ArrayList;
import java.util.List;

public class NowCoder {


    public ArrayList<Integer> printMatrix(int[][] matrix) {

        if (matrix == null) return null;

        ArrayList<Integer> res = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int upLimit = 0, leftLimit = 0;
        int downLimit = m - 1, rightLimit = n - 1;

        int cnt = m * n;

        for (int i = 0, j = 0; cnt > 0; cnt--) {
            res.add(matrix[i][j]);

            if (i == upLimit) {
                if (j < rightLimit) j++;
                else if (j == rightLimit) i++;
                continue;
            }

            if (j == rightLimit) {
                if (i < downLimit) i++;
                else if (i == downLimit) j--;
                continue;
            }

            if (i == downLimit) {
                if (j > leftLimit) j--;
                else if (j == leftLimit) i--;
                continue;
            }

            if (j == leftLimit) {
                if (i > upLimit + 1) i--;
                else if (i == upLimit + 1) {
                    j++;
                    upLimit++;
                    rightLimit--;
                    downLimit--;
                    leftLimit++;
                }
                continue;
            }

        }
        return res;
    }
}
