package com.fuchen.study.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description 设置默认的未捕获异常处理器
 * @Author fuchen
 * @Date 5/1/2019 10:16 PM
 * Version 1.0
 */
public class SettingDefaultHandler {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExecptionThread());
    }
}
