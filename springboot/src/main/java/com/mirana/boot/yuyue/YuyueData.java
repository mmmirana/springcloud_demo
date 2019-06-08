package com.mirana.boot.yuyue;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 预约数据，模拟数据库
 */
public class YuyueData {
    // 模拟数据库
    public static Map<String,Integer> phoneList=new ConcurrentHashMap<String,Integer>();

    /**
     * 新增預約
     * @param phone 手机号
     * @param status 状态码 0 尚未預約，1 预约完成
     */
    public static void newYuyue(String phone,Integer status){
        phoneList.put(phone,status);
    }

    /**
     * 模拟预约完成
     * @param phone
     */
    public static void yuyueSuccess(String phone){
        phoneList.put(phone,1);
    }
}
