package com.fuchen.study.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description try-catch捕获异常
 * @Author fuchen
 * @Date 5/1/2019 10:00 PM
 * Version 1.0
 */
public class NaiveExecptionHandling {
    public static void main(String[] args) {
        try {
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExecptionThread());
        } catch (RuntimeException eu) {
            // 下面这条语句不会被执行
            System.out.println("Execption has been handled!");
        }
    }
}
