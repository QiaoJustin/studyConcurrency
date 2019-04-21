package com.fuchen.study.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * @Author fuchen
 * @Date 4/21/2019 3:50 PM
 * Version 1.0
 */
public class Ex4 {
    public static void main(String[] args) {
        // newCachedThreadPool
        ExecutorService execA = Executors.newCachedThreadPool();
        execA.execute(new Ex4FibonacciA(15));
        execA.execute(new Ex4FibonacciB(15));
        execA.execute(new Ex4FibonacciC(15));
        execA.execute(new Ex4FibonacciD(15));
        execA.shutdown();

        // newFixedThreadPool
        ExecutorService execB = Executors.newFixedThreadPool(4);
        execB.execute(new Ex4FibonacciA(15));
        execB.execute(new Ex4FibonacciB(15));
        execB.execute(new Ex4FibonacciC(15));
        execB.execute(new Ex4FibonacciD(15));
        execB.shutdown();

        // newSingleThreadExecutor
        ExecutorService execC = Executors.newSingleThreadExecutor();
        execC.execute(new Ex4FibonacciA(15));
        execC.execute(new Ex4FibonacciB(15));
        execC.execute(new Ex4FibonacciC(15));
        execC.execute(new Ex4FibonacciD(15));
        execC.shutdown();
    }
}

class Ex4FibonacciA implements Runnable {
    private int n = 0;

    public Ex4FibonacciA(int n) {
        this.n = n;
    }

    private int fib(int x) {
        if (x < 2) return 1;
        return fib(x - 2) + fib(x - 1);
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
        System.out.println();
    }
}

class Ex4FibonacciB implements Runnable {
    private int n = 0;

    public Ex4FibonacciB(int n) {
        this.n = n;
    }

    private int fib(int x) {
        if (x < 2) return 1;
        return fib(x - 2) + fib(x - 1);
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
        System.out.println();
    }
}

class Ex4FibonacciC implements Runnable {
    private int n = 0;

    public Ex4FibonacciC(int n) {
        this.n = n;
    }

    private int fib(int x) {
        if (x < 2) return 1;
        return fib(x - 2) + fib(x - 1);
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
        System.out.println();
    }
}

class Ex4FibonacciD implements Runnable {
    private int n = 0;

    public Ex4FibonacciD(int n) {
        this.n = n;
    }

    private int fib(int x) {
        if (x < 2) return 1;
        return fib(x - 2) + fib(x - 1);
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
        System.out.println();
    }
}