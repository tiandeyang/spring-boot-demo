package com.dytian.future;

import org.nutz.json.Json;

import java.security.PublicKey;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Classname Client
 * @Description TODO
 * @Date 2019/4/15 10:58
 * @Created by Administrator
 */
public class Client {


    public static void main(String[] args) throws Exception {


        FutureTask futureTask = new FutureTask(new RealData("dytain"));
        ExecutorService executor = Executors.newFixedThreadPool(1);

        executor.submit(futureTask);

        Thread.sleep(1000);
        System.out.println("time is over ;time is out.................");

        // wait 1 second more,  until the future finished
        Object o = futureTask.get();
        System.out.println("future task is finished ");
        System.out.println(Json.toJson(o));


    }

}
