package com.fuchen.study.practice;

class Ex2FibonacciA implements Runnable {

    private int n = 0;

    public Ex2FibonacciA(int n){
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

class Ex2FibonacciB implements Runnable {
    private int n = 0;

    public Ex2FibonacciB(int n){
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

class Ex2FibonacciC implements Runnable {
    private int n = 0;

    public Ex2FibonacciC(int n){
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

class Ex2FibonacciD implements Runnable {
    private int n = 0;

    public Ex2FibonacciD(int n){
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

public class Ex2 {
    public static void main(String[] args) {
        Thread tA = new Thread(new Ex2FibonacciA(15));
        Thread tB = new Thread(new Ex2FibonacciA(15));
        Thread tC = new Thread(new Ex2FibonacciA(15));
        Thread tD = new Thread(new Ex2FibonacciA(15));

        tA.start();
        tB.start();
        tC.start();
        tD.start();
    }
}
