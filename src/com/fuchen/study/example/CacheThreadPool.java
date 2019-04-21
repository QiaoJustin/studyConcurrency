package com.fuchen.study.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description ExecutorService(具有服务生命周期的Executor，例如关闭)
 * @Author fuchen
 * @Date 4/21/2019 3:17 PM
 * Version 1.0
 */
public class CacheThreadPool {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
