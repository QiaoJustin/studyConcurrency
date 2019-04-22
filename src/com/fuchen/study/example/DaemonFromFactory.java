package com.fuchen.study.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description 每个静态的ExecutorService创建方法都被重载为接受一个ThreadFactory对象，而这个对象将被用来创建新的线程。
 * @Author fuchen
 * @Date 4/22/2019 9:04 PM
 * Version 1.0
 */
public class DaemonFromFactory implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MICROSECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            } catch (InterruptedException e) {
                System.out.println("Interrupted...");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            exec.execute(new DaemonFromFactory());
        }
        System.out.println("All daemons started");
        TimeUnit.MICROSECONDS.sleep(500);
    }
}
