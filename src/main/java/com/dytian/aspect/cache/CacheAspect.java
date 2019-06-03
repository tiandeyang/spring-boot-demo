package com.dytian.aspect.cache;

import org.apache.tomcat.jni.Time;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.nutz.json.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @Classname CacheAspect
 * @Description TODO
 * @Date 2019/5/28 11:51
 * @Created by Administrator
 */

@Aspect
@Component
public class CacheAspect {

    Logger logger = LoggerFactory.getLogger(CacheAspect.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("@annotation(com.dytian.aspect.cache.CacheAble)")
    public void pointCut() {}


    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        CacheAble annotation = method.getAnnotation(CacheAble.class);
        String key = annotation.key();
        int expireTime = annotation.expireTime();
        logger.info("key====46======="+key);
        if (redisTemplate.hasKey(key)){
            logger.info("key==============="+key);
            return Json.fromJson(Object.class,redisTemplate.opsForValue().get(key));
        }else {
            Object proceed = joinPoint.proceed();
            logger.info("proceed=51=============="+ Json.toJson(proceed));
            redisTemplate.opsForValue().set(key,Json.toJson(proceed),expireTime,TimeUnit.MINUTES);
            return proceed;
        }
    }

}
