package com.junhua.algorithm.offer;

public class NowCoder12 {

    static public double Power(double base, int exponent) {
        if (base == 0) return 0;
        if (exponent == 0) return 1;
        int n = (exponent > 0) ? exponent : -exponent;
        double x = (exponent > 0) ? base : 1 / base;
        if ((n & 1) == 1) {
            return x * Power(x * x, (n - 1) / 2);
        } else {
            return x * Power(x * x, 2 / 2);
        }
    }


}
