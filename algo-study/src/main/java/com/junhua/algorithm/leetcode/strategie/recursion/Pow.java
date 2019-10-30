package com.junhua.algorithm.leetcode.strategie.recursion;

public class Pow {

    public static int pow(int x, int n) {
        if (n == 1) return x;
        return x * pow(x, n - 1);
    }

    /**
     * 分治
     *
     * @param x
     * @param n
     * @return
     */
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


        System.out.print(pow4(2, 10));
    }

    static public int pow3(int x, int n) {
        if (n == 0) return 1;

        if (n % 2 == 0) {
            return pow3(x * x, n / 2);
        } else {
            return x * pow3(x * x, (n - 1) / 2);
        }
    }

    static public int pow4(int x, int n) {

        int pow = 1;
        while (n > 0) {
            if (n % 2 == 1) pow *= x;
            x = x * x;
            n = n / 2;
        }

        return pow;
    }
}
