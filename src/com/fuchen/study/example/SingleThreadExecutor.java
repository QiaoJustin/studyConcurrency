package com.fuchen.study.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description SingleThreadExecutor: 会序列化所有提交给它的任务，并维护它自己（隐藏）的悬挂任务队列。
 * @Author fuchen
 * @Date 4/21/2019 3:30 PM
 * Version 1.0
 */
public class SingleThreadExecutor {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        exec.shutdown();
    }
}
