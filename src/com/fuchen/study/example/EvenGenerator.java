package com.fuchen.study.example;

/**
 * @Description 共享受限资源
 * @Author fuchen
 * @Date 5/2/2019 10:06 AM
 * Version 1.0
 */
public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    @Override
    public synchronized int next() {
        // Danger point here!
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
