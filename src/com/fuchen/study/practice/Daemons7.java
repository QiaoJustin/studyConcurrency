package com.fuchen.study.practice;

/**
 * @Description 使用不同的休眠时间
 * @Author fuchen
 * @Date 5/1/2019 12:11 PM
 * Version 1.0
 */
public class Daemons7 {
    public static void main(String[] args) {
        Thread t = new Thread(new Daemon());
        t.setDaemon(true);
        t.start();
        System.out.println("t.isDaemon() = " + t.isDaemon() + ", ");
        // 不休眠
        // TimeUnit.SECONDS.sleep(1);
    }
}

class Daemon implements Runnable {
    private Thread[] t = new Thread[30];

    @Override
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn " + " started, ");
        }
        for (int i = 0; i < t.length; i++) {
            System.out.println("t[" + i + "].isDaemon() = " + t[i].isDaemon() + ", ");
        }
        while (true) {
            Thread.yield();
        }
    }
}

class DaemonSpawn implements Runnable {
    @Override
    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}