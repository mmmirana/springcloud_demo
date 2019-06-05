package com.mirana.boot;

public class AsyncYuyuThread implements Runnable {

    @Override
    public void run() {
        // 从数据库取出来
        System.out.println("正在操作数据库");
    }
}
