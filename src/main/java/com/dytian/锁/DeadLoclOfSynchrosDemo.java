package com.dytian.锁;

public class DeadLoclOfSynchrosDemo {

    static Object lock1 = new Object();
    static Object lock2 = new Object();


    public static void main(String[] args) {


        Thread thread1 = new Thread(new Worker(lock1, lock2));
        Thread thread2 = new Thread(new Worker(lock2, lock1));

        thread1.start();
        thread2.start();


    }


    static class Worker implements Runnable{


        public Worker(Object lock1, Object lock2) {
            this.lock1 = lock1;
            this.lock2 = lock2;
        }

        Object lock1;
        Object lock2;

        @Override
        public void run() {

            synchronized (lock1){
                System.out.println(Thread.currentThread().getName()+"  get lock111");
                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName()+"  get lock222");
                }
            }



        }
    }


}
