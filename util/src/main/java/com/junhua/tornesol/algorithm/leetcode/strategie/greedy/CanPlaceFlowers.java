package com.junhua.tornesol.algorithm.leetcode.strategie.greedy;

public class CanPlaceFlowers {

    static public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) return false;

        for (int i = 1; i < flowerbed.length - 1 & n > 0; i++) {
            if (flowerbed[i] == 1) continue;

            int pre = (i == 0) ? 0 : flowerbed[i - 1];
            int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];

            if (pre == 0 && next == 0) {
                n--;
                flowerbed[i] = 1;
            }
        }
        return n == 0;
    }

    public static void main(String[] args) {

        int[] flowerbed = {1, 0, 0, 0, 0,1};
        System.out.println(canPlaceFlowers(flowerbed, 2));
//        System.out.println(canPlaceFlowers(flowerbed, 1));
    }
}
