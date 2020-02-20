package com.dytian.jmm;

public class ThreadSafeCache {

    // volatile int result;
    volatile int result;

    public int getResult(){
        return result;
    }

    public void setResult(int result){
        this.result = result;
    }


    public static void main(String[] args) {


        ThreadSafeCache threadSafeCache = new ThreadSafeCache();

        for (int i = 0;i < 8;i++){
            new Thread(){
                @Override
                public void run() {
                    int x = 0;
                    while (threadSafeCache.getResult() < 100){
                        x++;
                    }
                    System.out.println("x="+x);
                }
            }.start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadSafeCache.setResult(200);

    }

    // 结论：多线程并发的同时进行set、get操作，A线程调用set方法，B线程并不一定能对这个改变可见！！！，上面的代码中，如果对get方法也加synchronized也是可见的，还是happens-before的监视器锁规则：对一个监视器的解锁，happens-before 于随后对这个监视器的加锁。，只是volatile比synchronized更轻量级，所以本例直接用volatile。但是对于符合非原子操作i++这里还是不行的还是需要synchronized。


}
