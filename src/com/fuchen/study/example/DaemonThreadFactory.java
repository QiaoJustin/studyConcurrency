package com.fuchen.study.example;

import java.util.concurrent.ThreadFactory;

/**
 * @Description 编写定制的ThreadFactory可以定制Executor创建的线程的属性（后台、优先级、名称）。
 * @Author fuchen
 * @Date 4/22/2019 9:01 PM
 * Version 1.0
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
