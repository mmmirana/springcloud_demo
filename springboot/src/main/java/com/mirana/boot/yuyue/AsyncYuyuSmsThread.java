package com.mirana.boot.yuyue;

import java.util.Map;
import java.util.Set;

public class AsyncYuyuSmsThread implements Runnable {

    @Override
    public void run() {
        while (true) {
            // 数据库模拟队列
            System.out.println("模拟发送短信");
            Set<Map.Entry<String, Integer>> yuyueSet = YuyueData.phoneList.entrySet();
            for (Map.Entry<String, Integer> entry : yuyueSet) {
                String phone = entry.getKey();
                Integer status = entry.getValue();
                if (status == 1)
                    System.out.println("正在发送预约成功的短信：" + phone);
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
