package com.fuchen.study.example;

/**
 * @Description 实现 Runnable 接口与继承 Thread 类之间的区别:
 *              实现接口可以继承另外一个不同的类，而从Thread继承不行
 * @Author fuchen
 * @Date 5/1/2019 3:39 PM
 * Version 1.0
 */
public class SelfManaged implements Runnable {
    private int countDown = 5;
    private Thread t = new Thread(this);

    @Override
    public void run() {
        while (true) {
            System.out.println(this);
            if (--countDown == 0)return;
        }
    }

    public SelfManaged() {
        t.start();
    }

    @Override
    public String toString() {
        return Thread.currentThread().getName() + "(" + countDown + "), ";
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SelfManaged();
        }
    }
}
