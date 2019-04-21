package com.fuchen.study.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description newFixedThreadPool:使用了有线的线程集来执行所提交的任务
 * @Author fuchen
 * @Date 4/21/2019 3:24 PM
 * Version 1.0
 */
public class FixedThreadPool {

    public static void main(String[] args) {
        // 创建5个线程
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        exec.shutdown();
    }
}
