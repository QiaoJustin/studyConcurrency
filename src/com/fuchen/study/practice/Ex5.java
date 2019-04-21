package com.fuchen.study.practice;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @Description 练习题5(对斐波拉契数列求和)：Callable接口
 * @Author fuchen
 * @Date 4/21/2019 4:28 PM
 * Version 1.0
 */
public class Ex5 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> results = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            results.add(exec.submit(new Ex5Fibonacci(i)));
        }
        for (Future<Integer> fs : results) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                exec.shutdown();
            }
        }
    }
}

class Ex5Fibonacci implements Callable<Integer> {
    private int n;

    public Ex5Fibonacci(int n) {
        this.n = n;
    }

    private int fib(int x){
        if (x < 2) return 1;
        return fib(x - 2) + fib(x -1);
    }

    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += fib(i);
        }
        return result;
    }
}