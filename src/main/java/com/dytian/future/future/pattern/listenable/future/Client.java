package com.dytian.future.future.pattern.listenable.future;

import com.google.common.util.concurrent.*;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/**
 * @Classname Client
 * @Description TODO
 * @Date 2019/4/15 14:48
 * @Created by Administrator
 */
public class Client {

    static    ListeningExecutorService ex = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(1));
    public static void main(String[] args) {

        ListenableFuture<String> task = ex.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.currentThread().sleep(5 * 1000);
                return "call ok;";
            }
        });

        // 任务1
        ListenableFuture<Boolean> booleanTask = ex.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return true;
            }
        });






    }

}
