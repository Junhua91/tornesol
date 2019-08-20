package com.junhua.tornesol.leetcode.strategie.math;


import java.util.Arrays;

/**
 * 素数
 */
public class CountPrimes {

    static public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) continue;
            res++;
            for (int j = 2; i * j < n; j++) {
                isPrime[i * j] = false;
            }
        }
        return res;
    }


    /**
     * the number must not be divisible by any number > n / 2
     *
     * @param n
     * @return
     */
    static public boolean isPrime(int n) {
        for (int i = n / 2; i > 1; i--) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
