package com.dytian.spring.dytianboot.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    public static final String DEFAULT_BOOK_QUEUE = "default_book_queue";
    public static final String MANUAL_BOOK_QUEUE = "default_book_queue";

    @Bean
    public Queue defalutQueue(){
        // 第二个参数 是否持久化
        return new Queue(DEFAULT_BOOK_QUEUE,true);
    }


    @Bean
    public Queue manualQueue(){
        // 第二个参数 是否持久化
        return new Queue(MANUAL_BOOK_QUEUE,true);
    }


}
