package com.dytian.design.pattern.single;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.lang.reflect.Constructor;

public enum CaffeineInstance {

    CAFFEINE_INSTANCE;

    private static final Cache<Object, Object> caffeine = Caffeine.newBuilder().build();
    public Cache<Object, Object>  getInstance(){
        return caffeine;
    }


    public static void main(String[] args) throws Exception {

        Constructor<CaffeineInstance> con = CaffeineInstance.class.getDeclaredConstructor();
        con.setAccessible(true);
        CaffeineInstance caffeineInstance = con.newInstance();

        CaffeineInstance caffeineInstance1 = con.newInstance();

        boolean b = caffeineInstance == caffeineInstance1;
        System.out.println("b==="+b);

    }


}

