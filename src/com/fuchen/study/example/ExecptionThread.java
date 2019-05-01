package com.fuchen.study.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description 捕获异常
 * @Author fuchen
 * @Date 5/1/2019 9:58 PM
 * Version 1.0
 */
public class ExecptionThread implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExecptionThread());
    }
}
