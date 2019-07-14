package com.junhua.tornesol.concurrent;

public class ThreadLocalDemo {


    /**
     * 1. ThreadLocal 只保存一个变量
     * 2.
     * @param args
     */
    public static void main(String[] args) {
        ThreadLocal<String> LOCAL_THREAD = new ThreadLocal<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                LOCAL_THREAD.set(Thread.currentThread().getName());
                LOCAL_THREAD.set(Thread.currentThread().getName() + "_test");

                System.out.println(LOCAL_THREAD.get());
                System.out.println(LOCAL_THREAD.get());
            }
            ).start();
        }



    }
}
