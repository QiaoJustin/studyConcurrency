package com.fuchen.study.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * @Author fuchen
 * @Date 4/21/2019 3:39 PM
 * Version 1.0
 */
public class Ex3 {

    public static void main(String[] args) {
        ExecutorService execA = Executors.newCachedThreadPool();
        execA.execute(new Ex3RunnerA());
        execA.execute(new Ex3RunnerB());
        execA.execute(new Ex3RunnerC());
        execA.shutdown();

        ExecutorService execB = Executors.newFixedThreadPool(3);
        execB.execute(new Ex3RunnerA());
        execB.execute(new Ex3RunnerB());
        execB.execute(new Ex3RunnerC());
        execB.shutdown();

        ExecutorService execC = Executors.newSingleThreadExecutor();
        execC.execute(new Ex3RunnerA());
        execC.execute(new Ex3RunnerB());
        execC.execute(new Ex3RunnerC());
        execC.shutdown();

    }
}

class Ex3RunnerA implements Runnable {

    public Ex3RunnerA() {
        System.out.println("构造 Ex3RunnerA");
    }
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Hi from Ex3RunnerA");
            Thread.yield();
        }
        System.out.println("Ex3RunnerA task complete.");
        return;
    }
}

class Ex3RunnerB implements Runnable {

    public Ex3RunnerB() {
        System.out.println("构造 Ex3RunnerB");
    }
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Hi from Ex3RunnerB");
            Thread.yield();
        }
        System.out.println("Ex3RunnerB task complete.");
        return;
    }
}

class Ex3RunnerC implements Runnable {

    public Ex3RunnerC() {
        System.out.println("构造 Ex3RunnerC");
    }
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Hi from Ex3RunnerC");
            Thread.yield();
        }
        System.out.println("Ex3RunnerC task complete.");
        return;
    }
}
