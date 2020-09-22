package com.dytian.rocketmq;


import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RocketmqConfig {


    @Autowired
    ApplicationEventPublisher applicationEventPublisher;



    @Bean
    public DefaultMQProducer mqProducer() throws MQClientException {

        DefaultMQProducer producer = new DefaultMQProducer("producerGroup0916");
        producer.setNamesrvAddr("localhost:9876");
        producer.start();
        return producer;

    }

    @Bean
    public DefaultMQPushConsumer mqConsumer() throws MQClientException {

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumerGroup0916");
        consumer.setNamesrvAddr("localhost:9876");
        consumer.subscribe("TopicTest", "*");
        consumer.setMessageListener(listenerConcurrently());
        // 最大消费重试次数
        consumer.setMaxReconsumeTimes(2);
        consumer.start();

        return consumer;
    }



    @Bean
    public MessageListenerConcurrently listenerConcurrently(){

        MessageListenerConcurrently listenerConcurrently = new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {

                MessageResultContext context = new MessageResultContext(false);
                MessageReceivedEvent event = new MessageReceivedEvent("", list, consumeConcurrentlyContext,context);

                applicationEventPublisher.publishEvent(event);

                if (!context.isOK){
                    try {
                        int i = 1 / 0;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                    }
                }
                System.out.println("consume ok;");
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        };

        return listenerConcurrently;
    }





}
