package com.junhua.tornesol.algorithm.leetcode;


/**
 * 对于单调递增特性的问题，可以采用二分法来求解
 * @author nali
 */
public class Sqrt {

    private static double PRECISION = 0.00001;

    /**
     * 二分法
     *
     * @param n
     * @return
     */
    public static double sqrt(int n) {

        double left = 1;
        double right = n;
        double mid = (left + right) / 2;
        while (Math.abs(mid * mid - n) > PRECISION) {
            if (mid * mid > n) {
                right = mid;
            } else {
                left = mid;
            }
            mid = (right + left) / 2;
        }
        return mid;
    }

//    public static double sqrt2(int n) {
//
//    }

    public static void main(String[] args) {

        System.out.println(sqrt(5));
        System.out.println(sqrt(2));
        System.out.println(sqrt(4));
        System.out.println(sqrt(6));
        System.out.println(sqrt(7));
        System.out.println(sqrt(9));

    }

}
