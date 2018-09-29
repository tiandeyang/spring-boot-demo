package com.dytian.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;



@RabbitListener(queues = "dytian")
@Component
@Slf4j
public class RabbitConsumer {

    @RabbitHandler
    public void process(String message){
        log.info("rabbit reviced message ==="+ message);
    }

}
