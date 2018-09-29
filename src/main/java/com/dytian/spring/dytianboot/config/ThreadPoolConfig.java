package com.dytian.spring.dytianboot.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

@Configuration
public class ThreadPoolConfig {


    @Bean(value = "consumerQueueThreadPool")
    public ExecutorService buildConsumerQueueThreadPool(){
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("consume-queue-thread-%d").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5), threadFactory, new ThreadPoolExecutor.AbortPolicy());
        return threadPoolExecutor;
    }

}
