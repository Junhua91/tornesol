package com.junhua.tornesol.util.leetcode.bit;

public class PowerOfFour {

    static public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (0x5555 & num) == 1;
    }
}
