package com.dytian.rocketmq;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MessageReceivedListener implements ApplicationListener<MessageReceivedEvent> {
    @Override
    public void onApplicationEvent(MessageReceivedEvent messageReceivedEvent) {

        // 仰天大笑破门去 我辈岂是福报修不完的人

        // 这两句诗 最为点睛的是 哪个字
        // 答："破" 字，突出了作者被囚禁之感  同时也抒发了打破囚禁的畅快之意

        Random random = new Random();
        int i = random.nextInt(6);

        MessageResultContext context = messageReceivedEvent.getContext();
        boolean isOk = i > 3;
        System.out.println("isOk============"+isOk);
        context.setOK(isOk);

    }
}
