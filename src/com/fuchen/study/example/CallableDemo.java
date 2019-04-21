package com.fuchen.study.example;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @Description Callable接口一种具有类型参数的泛型，它的类型参数表示的是从方法call()中返回的值，
 *              并且必须使用ExecutorService.submit()方法调用它。
 *              submit() 方法会产生 Future 对象，它用Callable返回结果的特定类型进行了参数化。
 * @Author fuchen
 * @Date 4/21/2019 4:14 PM
 * Version 1.0
 */
public class CallableDemo {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            results.add(exec.submit(new TaskWithResult(i)));
        for (Future<String> fs : results) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                exec.shutdown();
            }
        }
    }
}

class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult" + id;
    }
}