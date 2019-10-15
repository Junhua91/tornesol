package com.junhua.tornesol.algorithm.leetcode.datastructure.array;

public class BeautifulArrangementII {


    static public int[] constructArray(int n, int k) {
        if (k >= n) return null;
        int[] res = new int[n];
        int small = 1;
        int large = n;
        int i = 0;
        while (i < k) {
            res[i++] = small++;
            if (i < k)
                res[i++] = large--;
        }
        if (k % 2 == 1) while (i < n) res[i++] = small++;
        else while (i < n) res[i++] = large--;
        return res;
    }

    public static void main(String[] args) {

        int[] res = constructArray(6, 2);
        return;
    }
}
