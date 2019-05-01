package com.fuchen.study.practice;

import com.fuchen.study.example.LiftOff;

/**
 * @Description 后台线程
 * @Author fuchen
 * @Date 5/1/2019 3:03 PM
 * Version 1.0
 */
public class MoreBasicThreads8 {
    public static void main(String[] args) {
        try {
            // 增加线程数量
            for (int i = 0; i < 25; i++) {
                Thread t = new Thread(new LiftOff());
                t.setDaemon(true);
                t.start();
            }
            System.out.println("Waiting for LiftOff");
        } finally {
            System.out.println("Finally out of main");
        }
    }
}
