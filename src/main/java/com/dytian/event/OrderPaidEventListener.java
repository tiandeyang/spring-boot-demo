package com.dytian.event;

import org.nutz.json.Json;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class OrderPaidEventListener implements ApplicationListener<OrderPaidEvent> {

    @Override
    public void onApplicationEvent(OrderPaidEvent orderPaidEvent) {
        System.out.println("order paid："+ Json.toJson(orderPaidEvent));
    }


}
