package com.fuchen.study.example;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 使用 synchronized 关键字不能尝试着获取锁且在最终获取锁会失败，或者尝试着获取锁一段时间，
 *              然后放弃它，要实现这些，必须使用concurrent类库。
 * @Author fuchen
 * @Date 5/2/2019 3:51 PM
 * Version 1.0
 */
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();

    public void untimed () {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if (captured) lock.unlock();
        }
    }

    public void timed () {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS): " + captured);
        } finally {
            if (captured) lock.unlock();
        }
    }

    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.untimed();  // True -- lock is available
        al.timed();    // True -- lock is available
        // now create a separate task to grap the lock:
        new Thread() {
            {setDaemon(true);}
            public void run() {
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();
    }
}
