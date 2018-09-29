package com.dytian.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;
import java.util.concurrent.CountDownLatch;

@Data
@AllArgsConstructor
public class Worker implements Runnable {

    private CountDownLatch countDownLatch;

    private Set<Long> longSet;

    private IdWorker idWorker;



    @Override
    public void run() {
        for (int i = 0 ; i < 100 ;i++){
            longSet.add(idWorker.nextId());
          //  System.out.println(longSet.size());
        }
        countDownLatch.countDown();
    }
}
