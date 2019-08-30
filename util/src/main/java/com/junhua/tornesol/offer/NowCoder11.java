package com.junhua.tornesol.offer;

public class NowCoder11 {

    static public int NumberOf1(int n) {
        int count = 0;

        while (n != 0) {
            if ((n & 1) == 1) count++;
            n >>>= 1;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(8));
        System.out.println(NumberOf1(-1));
    }
}
