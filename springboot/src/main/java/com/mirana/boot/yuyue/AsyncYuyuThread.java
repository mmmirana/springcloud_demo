package com.mirana.boot.yuyue;

import java.util.Map;
import java.util.Set;

public class AsyncYuyuThread implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("模拟预约");
            Set<Map.Entry<String, Integer>> yuyueSet = YuyueData.phoneList.entrySet();
            for (Map.Entry<String, Integer> entry : yuyueSet) {
                String phone = entry.getKey();
                try {
                    Thread.sleep(1500);
                    System.out.println("预约成功：" + phone);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
