package com.dytian.future.future.pattern.promise;


import io.netty.util.concurrent.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname NettyPromise
 * @Description TODO
 * @Date 2019/4/16 9:35
 * @Created by Administrator
 */
public class NettyPromise {


    public static void request(){

        DefaultEventExecutor eventExecutors = new DefaultEventExecutor();
        Promise<String> promise = new DefaultPromise(eventExecutors);

        ExecutorService executor = Executors.newFixedThreadPool(1);

        executor.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(8*1000);
                    System.out.println("setSuccess is done !");
                    promise.setSuccess("result is ok");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        promise.addListener(new GenericFutureListener<Future<? super String>>() {
            @Override
            public void operationComplete(Future<? super String> future) throws Exception {
                System.out.println("wait a long time,the result is ok:"+future.get());
            }
        });


       // eventExecutors.shutdownGracefully();
        executor.shutdown();
        System.out.println("....shut_down.....");
     //   eventExecutors.shutdownGracefully();






    }

    public static void main(String[] args) {
        NettyPromise.request();
    }

}
