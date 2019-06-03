package com.dytian.guava.event;


import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.common.reflect.TypeToken;
import lombok.val;
import org.nutz.json.Json;

import java.util.Set;

public class EventBusTest {

    private static final EventBus eventBus = new EventBus("yuemeeOrder");


    static class Listener{

        @Subscribe
        public void onMessage(String msg){
            System.out.println("收到信息:"+msg);
        }

    }

    static class EventListener{

        @Subscribe
        public void handleEvent(Event event){
            System.out.println("event=="+ Json.toJson(event));
        }

        @Subscribe
        public void handleLoginEvent(LoginEvent event){
            System.out.println("loginEvent=="+Json.toJson(event));
        }

    }


    public static void main(String[] args) {

        eventBus.register(new Listener());
        eventBus.register(new EventListener());

        EventBusTest.eventBus.post("新鲜出炉的数据哦..");
        Event loginEvent = new LoginEvent("logEvent.........");
        EventBusTest.eventBus.post(loginEvent);
        EventBusTest.eventBus.post(new RegisterEvent("18363861928"));
        Set<Class<?>> classes = (Set<Class<?>>) TypeToken.of(loginEvent.getClass()).getTypes().rawTypes();
        classes.forEach(klazz-> System.out.println(klazz.getName()));



    }

}
