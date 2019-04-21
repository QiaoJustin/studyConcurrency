package com.fuchen.study.practice;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description 练习题6：创建一个任务，它将睡眠1至10秒之间的随机数量的时间，然后显示它的睡眠时间并退出。
 *              创建并运行一定数量的这种任务。
 * @Author fuchen
 * @Date 4/21/2019 9:54 PM
 * Version 1.0
 */
public class Ex6 implements Runnable {
    Random random = new Random();

    @Override
    public void run() {
        int t = 1000 * random.nextInt(10);
        try {
            TimeUnit.MICROSECONDS.sleep(t);
            System.out.println("Slept " + t / 1000 + " seconds");
            return;
        } catch (InterruptedException e) {
            System.err.println("Interrupted");
        }
    }

    public static void main(String[] args) {
        if (args.length < 1)
            System.out.println("请输入一个数字： ");
        if (args.length == 1) {
            int n = Integer.parseInt(args[0]);
            ExecutorService exec = Executors.newCachedThreadPool();
            for (int i = 0; i < n; i++){
                exec.execute(new Ex6());
            }
            exec.shutdown();
        }
    }
}