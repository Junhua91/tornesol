package com.junhua.tornesol.util.leetcode.recursion;

public class Pow {

    public static int pow(int x, int n) {
        if (n == 1) return x;
        return x * pow(x, n - 1);
    }

    public static int pow2(int x, int n) {

        if (n == 0) return 1;

        if (n < 0) {
            return 1 / pow2(x, -n);

        }
        if (n % 2 == 0) {
            return pow2(x * x, n / 2);
        } else {
            return x * pow2(x * x, (n - 1) / 2);
        }
    }

    public static void main(String[] args) {
        Long start1 = System.currentTimeMillis();
        System.out.print(pow(2, 30));
        Long end1 = System.currentTimeMillis();
        System.out.println("time takes " + (end1 - start1));


        Long start2 = System.currentTimeMillis();
        System.out.print(pow2(2, 30));
        Long end2 = System.currentTimeMillis();
        System.out.println("time takes " + (end2 - start2));
    }
}
