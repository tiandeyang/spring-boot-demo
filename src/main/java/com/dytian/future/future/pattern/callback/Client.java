package com.dytian.future.future.pattern.callback;

import org.nutz.json.Json;

/**
 * @Classname Client
 * @Description TODO
 * @Date 2019/4/15 14:32
 * @Created by Administrator
 */
public class Client  {

    public static void main(String[] args) {

        ManageFiled manageFiled = new ManageFiled();
        manageFiled.setName("dytian");

        TimeUtil util = new TimeUtil(new TimeListener() {
            @Override
            public String getTime(String data) {
                System.out.println("data========"+data);
                return data;
            }
        });

        manageFiled.setBeijingTime(util.getTime());
        System.out.println(Json.toJson(manageFiled));


    }


}
