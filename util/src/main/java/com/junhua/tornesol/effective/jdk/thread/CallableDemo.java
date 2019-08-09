package com.junhua.tornesol.effective.jdk.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return 1;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(new CallableDemo());
        Thread thread = new Thread(task);
        thread.start();
        System.out.println(Thread.currentThread().getName());
        System.out.println(task.get());

    }
}
