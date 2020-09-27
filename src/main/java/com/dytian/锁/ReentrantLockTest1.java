package com.dytian.锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest1 {

    // 大部分情况下我们使用非公平锁，因为其性能比公平锁好很多。但是公平锁能够避免线程饥饿，某些情况下也很有用。
    static Lock lock = new ReentrantLock(false);


    public static void main(String[] args) throws InterruptedException {

        for(int i=0;i<2;i++){
            new Thread(new ThreadDemo(i)).start();
        }

    }

    static class ThreadDemo implements Runnable {
        Integer id;

        public ThreadDemo(Integer id) {
            this.id = id;
        }

        @Override

      public void run() {

            System.out.println( Thread.currentThread().getName() + "  come in");

            for(int i=0;i<2;i++){
                System.out.println(Thread.currentThread().getName()+"  试图获取到锁");
                lock.lock();
                System.out.println( Thread.currentThread().getName() + "  获得锁的线程："+id);
                try {
                    TimeUnit.MILLISECONDS.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        }


    }
}