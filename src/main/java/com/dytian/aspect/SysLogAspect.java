package com.dytian.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.nutz.json.Json;
import org.nutz.lang.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class SysLogAspect {

    @Autowired
    private SysLogService sysLogService;

    @Pointcut("@annotation(com.dytian.aspect.SysLog)")
    public void logPointCut(){}

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {


        long startTime = System.currentTimeMillis();
        joinPoint.proceed();
        long timespan = System.currentTimeMillis() - startTime;

        saveLog(joinPoint,timespan);


        return null;

    }

    private void saveLog(ProceedingJoinPoint joinPoint, long timespan) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLogBO sysLogBO = new SysLogBO();
        sysLogBO.setExeuTime(timespan);

        sysLogBO.setCreateDate(Times.sDT(Times.now()));
        SysLog sysLog = method.getAnnotation(SysLog.class);
        if (null != sysLog){
            sysLogBO.setRemark(sysLog.value());
        }
        String className = joinPoint.getTarget().getClass().getName();
        sysLogBO.setClassName(className);
        String methodName = signature.getName();
        sysLogBO.setMethodName(methodName);

        Object[] args = joinPoint.getArgs();

        List<String> list = new ArrayList<>();
        for (Object o:args){
            list.add(Json.toJson(o));
        }
        sysLogBO.setParams(list.toString());
        sysLogService.save(sysLogBO);


    }


}
