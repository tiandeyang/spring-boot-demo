package com.dytian.guava.event;

public class Worker implements Runnable {


    private ThreadLocal<Integer> qunee = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 100;
        }
    };

    @Override
    public void run() {
        Integer integer = qunee.get();
        System.out.println("int===="+integer--);
        qunee.set(integer);
        System.out.println(Thread.currentThread().getName()+ "===after=="+qunee.get());
    }


    public static void main(String[] args) {
       for (int i=0;i < 20;i++){
           new Thread(new Worker()).start();
       }

    }



}
