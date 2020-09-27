package com.dytian.multithread;

import java.util.concurrent.Executors;

public class Starter {


    public static void main(String[] args) {

        NioServerBoss nioServerBoss = new NioServerBoss(Executors.newCachedThreadPool());

    }

}
