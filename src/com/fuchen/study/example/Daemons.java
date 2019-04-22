package com.fuchen.study.example;

import java.util.concurrent.TimeUnit;

/**
 * @Description 可以通过调用isDaemon()方法来确定线程是否是一个后台线程。如果是一个后台线程，那么它创建的任何线程将被自动
 *              设置为后台线程。
 * @Author fuchen
 * @Date 4/22/2019 9:16 PM
 * Version 1.0
 */
public class Daemons {
    public static void main(String[] args) throws Exception {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d.isDaemon() = " +d.isDaemon() + "; ");
        TimeUnit.SECONDS.sleep(3);
    }
}

class Daemon implements Runnable {
    private Thread[] t = new Thread[10];
    @Override
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn " + i + " started;  ");
        }
        for (int i = 0; i < t.length; i++) {
            System.out.println("t[" + i + "].isDaemon() = " + t[i].isDaemon() + "; ");
        }
        while (true)
            Thread.yield();
    }
}

class DaemonSpawn implements Runnable {
    @Override
    public void run() {
        while (true)
            Thread.yield();
    }
}