package com.dytian.锁;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadConditionTest {


    private static   ReentrantLock lock = new ReentrantLock();

    private static Condition signal = lock.newCondition();




    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println("卡这了........1111111111");
                    signal.await();
                    System.out.println("111111111111111111111111111111111111111111");
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
                lock.unlock();
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println("卡这了........2222222222222");
                    signal.await();
                    System.out.println("22222222222222222222222222222222");
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
                lock.unlock();
            }
        }).start();




        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    Thread.currentThread().sleep(4*1000);
                    System.out.println("33333333333333333333333333");
                    signal.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
                lock.unlock();
            }
        }).start();










    }

}
