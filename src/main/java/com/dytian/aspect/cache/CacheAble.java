package com.dytian.aspect.cache;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * @Classname CacheAble
 * @Description TODO
 * @Date 2019/5/28 11:49
 * @Created by Administrator
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheAble {

    String key() default "";

    int expireTime() default 5;

    TimeUnit unit() default TimeUnit.MINUTES;

}
