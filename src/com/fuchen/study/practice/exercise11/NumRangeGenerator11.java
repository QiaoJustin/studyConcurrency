package com.fuchen.study.practice.exercise11;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description 创建一个类，它包含两个数据域和一个操作这些域的方法，其操作过程是多步骤的。
 *              这样在该方法执行过程中，这些域将处于“不正确的状态”，添加这些域的方法，
 *              创建多个线程去调用各种方法，并展示处于“不正确状态的”数据是可视的。
 *              使用synchronized关键字修复这个问题。
 * @Author fuchen
 * @Date 5/2/2019 3:05 PM
 * Version 1.0
 */
public class NumRangeGenerator11 extends NumRangeGenerator {
    private int min = 0;
    private int max = 0;
    private int[] range = {min, max};
    private Random rand = new Random();

    @Override
    public int[] next() {// oops, method should be synchronized
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
        NumRangeChecker11.test(new NumRangeGenerator11());
    }
}

// non-task, non-Runnable, can be canceled
abstract class NumRangeGenerator {
    private volatile boolean canceled = false;
    public abstract int[] next();
    public void cancel(){canceled = true;}
    public boolean isCanceled() {return canceled;}
}

// task(s) that depend on & share NumRangeGenerator
class NumRangeChecker11 implements Runnable  {
    private NumRangeGenerator generator;
    private final int id;

    public NumRangeChecker11(NumRangeGenerator g, int ident) {
        generator = g;
        id = ident;
    }

    @Override
    public void run() {
        System.out.println("Testing...");
        while (!generator.isCanceled()) {
            int[] range = generator.next();
            if (range[0] > range[1]) {
                System.out.println("Error in test #" + id + ": min " + range[0] + " > " + " Max " + range[1]);
                generator.cancel();
            }
        }
    }

    public static void test(NumRangeGenerator g, int count) {
        System.out.println("Press Control-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new NumRangeChecker11(g, i));
        }
        exec.shutdown();
    }

    public static void test(NumRangeGenerator g) {
        test(g, 10);
    }
}