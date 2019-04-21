package com.fuchen.study.practice;

/**
 * 线程A
 */
class Ex1RunnerA implements Runnable {

    public Ex1RunnerA(){
        System.out.println("Constructing Ex1RunnerA.");
    }
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Ex1RunnerA Start Task...");
            Thread.yield();
        }
        System.out.println("Ex1RunnerA task complete.");
        return;
    }
}

/**
 * 线程B
 */
class Ex1RunnerB implements Runnable {

    public Ex1RunnerB() {
        System.out.println("Constructing Ex1RunnerB.");
    }
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Ex1RunnerB Start Task...");
            Thread.yield();
        }
        System.out.println("Ex1RunnerB task complete.");
        return;
    }
}

/**
 * 线程C
 */
class Ex1RunnerC implements Runnable {

    public Ex1RunnerC() {
        System.out.println("Constructing Ex1RunnerC.");
    }
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Ex1RunnerC Start Task...");
            Thread.yield();
        }
        System.out.println("Ex1RunnerC task complete.");
        return;
    }
}


public class Ex1 {

    public static void main(String[] args) {
        Thread tA = new Thread(new Ex1RunnerA());
        Thread tB = new Thread(new Ex1RunnerB());
        Thread tC = new Thread(new Ex1RunnerC());

        tA.start();
        tB.start();
        tC.start();
    }

}
