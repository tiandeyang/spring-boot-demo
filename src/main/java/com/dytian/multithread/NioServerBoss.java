package com.dytian.multithread;

import java.util.concurrent.Executor;

public class NioServerBoss implements Runnable {


    private final Executor executor;

    public NioServerBoss(final Executor executor) {

        this.executor = executor;
        this.executor.execute(this);
    }


    @Override
    public void run() {


        while (true){


            try {
                Thread.currentThread().sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("running...........");

        }


    }
}
