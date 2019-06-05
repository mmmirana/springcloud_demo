package com.mirana.boot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncProcessor {
    private static ExecutorService executorService= Executors.newCachedThreadPool();

    public static void main(String[] args) {
        executorService.execute(new AsyncYuyuThread());
    }
}
