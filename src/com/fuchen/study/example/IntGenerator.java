package com.fuchen.study.example;

/**
 * @Description 共享受限资源
 * @Author fuchen
 * @Date 5/2/2019 9:54 AM
 * Version 1.0
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;

    public abstract int next();

    // Allow this to be canceled
    public void cancel(){canceled = true; }

    public boolean isCanceled() {return canceled; }
}
