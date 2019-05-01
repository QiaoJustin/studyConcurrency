package com.fuchen.study.practice;

import java.util.concurrent.*;

/**
 * @Description 练习题10，P1142
 * @Author fuchen
 * @Date 5/1/2019 4:17 PM
 * Version 1.0
 */
public class Ex10 {
    public static void main(String[] args) {
        Ex10Fibonacci fib = new Ex10Fibonacci();
        try {
            for (int i = 0; i < 15; i++) {
                System.out.print("Sum of First " + i + " Fibonacci numbers ");
                System.out.println(fib.runTask(i).get());
            }
        } catch (InterruptedException e) {
            System.out.println(e);
            return;
        } catch (ExecutionException e) {
            System.out.println(e);
        } finally {
            fib.service.shutdown();
        }
    }
}

class Ex10Fibonacci implements Callable<Integer> {
    private Integer n = 0;
    ExecutorService service = Executors.newSingleThreadExecutor();

    private int fib(int x) {
        if (x < 2) return 1;
        return fib(x - 2) + fib(x - 1);
    }

    @Override
    public Integer call() {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += fib(i);
        }
        return result;
    }

    public Future<Integer> runTask(Integer n) {
        this.n = n;
        return  service.submit(this);
    }
}