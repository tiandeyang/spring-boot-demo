package com.dytian.rocketmq;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.context.ApplicationEvent;

import java.util.List;

public class MessageReceivedEvent extends ApplicationEvent {


    public MessageReceivedEvent(Object source) {
        super(source);
    }


    List<MessageExt> list;
    ConsumeConcurrentlyContext consumeConcurrentlyContext;
    MessageResultContext context;



    public MessageReceivedEvent(Object source, List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext, MessageResultContext context) {
        super(source);
        this.list = list;
        this.consumeConcurrentlyContext = consumeConcurrentlyContext;
        this.context = context;
    }


    public MessageResultContext getContext() {
        return context;
    }

    public void setContext(MessageResultContext context) {
        this.context = context;
    }

    public List<MessageExt> getList() {
        return list;
    }

    public void setList(List<MessageExt> list) {
        this.list = list;
    }

    public ConsumeConcurrentlyContext getConsumeConcurrentlyContext() {
        return consumeConcurrentlyContext;
    }

    public void setConsumeConcurrentlyContext(ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        this.consumeConcurrentlyContext = consumeConcurrentlyContext;
    }
}
