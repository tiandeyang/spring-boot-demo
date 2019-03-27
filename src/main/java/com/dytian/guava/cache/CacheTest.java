package com.dytian.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.nutz.json.Json;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CacheTest {

    LoadingCache<String, Object> cache = CacheBuilder.newBuilder()
            .maximumSize(100)
            .expireAfterWrite(6, TimeUnit.SECONDS)
            .build(new CacheLoader<String, Object>() {
                // 避免了缓存穿透的危险
                @Override
                public Object load(String key) throws Exception {
                    System.out.println("cacha inited !!");
                    return key + ":" + key;
                }
            });

//    public void put(){
//
//        try {
//            cache.invalidate("zero");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public void get() throws ExecutionException {
        Object o = cache.get("zero");
        System.out.println("get=="+Json.toJson(o));
    }

    public static void main(String[] args) throws InterruptedException {

        CacheTest cacheTest = new CacheTest();
    //    cacheTest.put();
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(5*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    cacheTest.get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    cacheTest.get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }.start();




    }





}
