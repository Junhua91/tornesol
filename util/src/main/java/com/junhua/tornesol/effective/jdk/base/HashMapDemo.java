package com.junhua.tornesol.effective.jdk.base;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) throws IOException {

        System.out.println(tableSizeFor(15));

    }

    /**
     * 保证容量永远是2^n: 3=>2^2, 5=>2^3...
     *
     * @param cap
     * @return
     */
    public static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
