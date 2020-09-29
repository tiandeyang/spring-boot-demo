package com.dytian.multithread.countDownAndCyclicBarrier;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class CountDownThreadFactory implements ThreadFactory {

    private static AtomicInteger index = new AtomicInteger(0);

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r,"thread-count-down-"+index.getAndIncrement());
    }
}
