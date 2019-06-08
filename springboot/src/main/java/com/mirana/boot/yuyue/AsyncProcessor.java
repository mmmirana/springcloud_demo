package com.mirana.boot.yuyue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncProcessor {
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    /**
     * 开启异步线程
     */
    public static void startAsyncThread() {
        // 预约线程
        executorService.execute(new AsyncYuyuThread());
        // 预约成功发送短信线程
        executorService.execute(new AsyncYuyuSmsThread());
    }
}
