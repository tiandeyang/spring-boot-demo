package com.dytian.message.queue.rabbit;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Recv {


    public static void main(String[] args) throws IOException, TimeoutException {


        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("hello",false,false,false,null);
        System.out.println("waiting from message   ");

        Consumer consumer = new DefaultConsumer(channel){

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {

               String message = new String(body,"UTF-8");
                System.out.println("received "+message);

            }
        };
        channel.basicConsume("hello",true,consumer);



    }


}
