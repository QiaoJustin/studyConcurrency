package com.fuchen.study.practice;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @Description 设置线程的优先级
 * @Author fuchen
 * @Date 5/1/2019 3:08 PM
 * Version 1.0
 */
public class SimplePriorities9 implements Runnable {
    private int countDown = 5;
    private volatile double d;

    @Override
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0) {
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0) return;
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool(new SimplePriorities9ThreadFactory());
        for (int i = 0; i < 5; i++) {
            es.execute(new SimplePriorities9());
        }
        es.execute(new SimplePriorities9());
        es.shutdown();
    }
}

class SimplePriorities9ThreadFactory implements ThreadFactory {
    Random rand = new Random();
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        int i = rand.nextInt(3);
        switch (i) {
            case 0:
                t.setPriority(Thread.MIN_PRIORITY);
                break;
            case 1:
                t.setPriority(Thread.NORM_PRIORITY);
                break;
            case 2:
                t.setPriority(Thread.MAX_PRIORITY);
                break;
        }
        return t;
    }
}