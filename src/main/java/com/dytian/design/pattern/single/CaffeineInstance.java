package com.dytian.design.pattern.single;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

public enum CaffeineInstance {

    CAFFEINE_INSTANCE;

    private static final Cache<Object, Object> caffeine = Caffeine.newBuilder().build();
    public Cache<Object, Object>  getInstance(){
        return caffeine;
    }

}
