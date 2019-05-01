package com.fuchen.study.example;

/**
 * @Description 创建有响应的用户界面
 * @Author fuchen
 * @Date 5/1/2019 9:44 PM
 * Version 1.0
 */
public class ResponsiveUI extends Thread {
    private static volatile double d = 1;

    public ResponsiveUI() {
        setDaemon(true);
        start();
    }

    public void run() {
        while (true) {
            d = d + (Math.PI + Math.E) / d;
        }
    }

    public static void main(String[] args) throws Exception {
        // 不能 new UnresponsiveUI，必须杀掉这个进程
        new ResponsiveUI();
        System.in.read();
        // 打印进程
        System.out.println(d);
    }
}

class UnresponsiveUI {
    private volatile double d = 1;
    public UnresponsiveUI() throws Exception {
        while (d > 0) {
            d = d + (Math.PI + Math.E) / d;
            // 不能从这里获取键盘输入值
            System.in.read();
        }
    }
}