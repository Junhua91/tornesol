package com.junhua.tornesol.guava.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;

import java.util.Arrays;

public class RateLimiterDemo {

    public static void main(String[] args) {
        RateLimiter limiter = RateLimiter.create(10);

        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14).parallelStream().forEach(p -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("wait Time:" + limiter.acquire());
                }
        );
    }

}
