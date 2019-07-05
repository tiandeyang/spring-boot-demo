package com.dytian.timer;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Classname TimerTest
 * @Description TODO
 * @Date 2019/4/22 14:59
 * @Created by Administrator
 */
public class TimerTest {


    HashedWheelTimer timer = new HashedWheelTimer(1,TimeUnit.SECONDS);

    public  void runTask(){

        timer.newTimeout(new Task(),1,TimeUnit.SECONDS);
        timer.newTimeout(new Task(),2,TimeUnit.SECONDS);
        timer.newTimeout(new Task(),3,TimeUnit.SECONDS);

        timer.newTimeout(new Task(),4,TimeUnit.SECONDS);
        timer.newTimeout(new Task(),5,TimeUnit.SECONDS);
        timer.newTimeout(new Task(),6,TimeUnit.SECONDS);
        timer.start();


        List<String> list = new ArrayList<>();
        list.add("string");

        final Map<String, String> map = new HashMap<>();
        map.put("hello","hello");



    }

    public static void main(String[] args) {
        new TimerTest().runTask();
    }







}
