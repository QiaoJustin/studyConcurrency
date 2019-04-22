package com.fuchen.study.example;

import java.util.concurrent.TimeUnit;

/**
 * @Description 当使用setDaemon设置线程为后台线程的时候，不会执行finally语句块。
 * @Author fuchen
 * @Date 4/22/2019 9:30 PM
 * Version 1.0
 */
public class DaemonsDontRunFinally {
    public static void main(String[] args) {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
    }
}

class ADaemon implements Runnable {
    @Override
    public void run() {
        System.out.println("Starting ADaemon");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Exiting via InterruptedExecption");
        } finally {
            System.out.println("This should always run?");
        }
    }
}