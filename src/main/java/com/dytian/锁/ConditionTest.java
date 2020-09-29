package com.dytian.锁;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    // Condition接口在使用前必须先调用ReentrantLock的lock()方法获得锁。之后调用Condition接口的await()将释放锁,并且在该Condition上等待,
    // 直到有其他线程调用Condition的signal()方法唤醒线程。使用方式和wait,notify类似。

    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();



    public static void main(String[] args) throws InterruptedException {

        lock.lock();
        new Thread(new SignalThread()).start();
        System.out.println( Thread.currentThread().getName() + "主线程等待通知");
        try {
            condition.await();
        } finally {
            lock.unlock();
        }
        System.out.println( Thread.currentThread().getName()+ "   主线程恢复运行");
    }
    static class SignalThread implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {

                try {
                    Thread.currentThread().sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                condition.signal();
                System.out.println( Thread.currentThread().getName() +  "  子线程通知");
            } finally {
                lock.unlock();
            }
        }
    }
}