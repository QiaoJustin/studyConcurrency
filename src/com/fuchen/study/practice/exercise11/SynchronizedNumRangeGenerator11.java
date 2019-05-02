package com.fuchen.study.practice.exercise11;

import java.util.Random;

/**
 * @Description SynchronizedNumRangeGenerator11
 * @Author fuchen
 * @Date 5/2/2019 3:28 PM
 * Version 1.0
 */
public class SynchronizedNumRangeGenerator11 extends NumRangeGenerator {
    private int min = 0;
    private int max = 0;
    private int[] range = {min, max};
    private Random rand = new Random();

    @Override
    public synchronized int[] next() { // synchronized!
        min = rand.nextInt(100);
        max = rand.nextInt(100);
        Thread.yield();
        if (min > max) {
            max = min;
        }
        int ia[] = {min, max};
        return ia;
    }

    public static void main(String[] args) {
        NumRangeChecker11.test(new SynchronizedNumRangeGenerator11());
    }
}
