package com.fuchen.study.example;

import java.util.concurrent.TimeUnit;

/**
 * @Description 后台线程：是指程序运行的时候在后台提供一种通用的线程，并且这种线程并不属于程序中的所有不可或缺的部分。
 *              只要有任何非后台程序还在运行，程序就不会终止。比如，执行一个main()的就是一个非后台线程。
 * @Author fuchen
 * @Date 4/22/2019 8:45 PM
 * Version 1.0
 */
public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MICROSECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() Interrupted");
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread deamon = new Thread(new SimpleDaemons());
            // 必须在 start() 方法之前调用setDaemon
            deamon.setDaemon(true);
            deamon.start();
        }
        System.out.println("All daemon started");
        TimeUnit.MICROSECONDS.sleep(175);
    }
}
