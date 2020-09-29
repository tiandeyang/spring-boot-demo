package com.dytian.multithread.countDownAndCyclicBarrier;



import java.util.concurrent.*;


public class CoundDownLatchTest {




    // 计算类型推荐N+1 I/O类型 推荐使用cpu数量*2

    //                              corePoolSize,
    //                              int maximumPoolSize,
    //                              long keepAliveTime,
    //                              TimeUnit unit,
    //                              BlockingQueue<Runnable> workQueue,
    //                              ThreadFactory threadFactory,
    //                              RejectedExecutionHandler handler

    private static ThreadFactory threadFactory = new CountDownThreadFactory();



    private     ExecutorService executors = null;

    public CoundDownLatchTest(int cpuNum) {

        executors = new ThreadPoolExecutor( cpuNum*2,
                cpuNum*2+1, 0,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(16),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy());
    }

    public void addTask(Runnable task){
        executors.submit(task);
    }


    public void shutdown(){
        executors.shutdown();
    }


    static   CountDownLatch latch2 = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {

        final int cpuNum = Runtime.getRuntime().availableProcessors();
        System.out.println("cpu核心数==="+cpuNum);
        CoundDownLatchTest executors = new CoundDownLatchTest(cpuNum);

        CountDownLatch latch = new CountDownLatch(2);


        executors.addTask(new Runnable() {
            @Override
            public void run() {
                try {
                 Thread.currentThread().sleep(1000*4);
                    System.out.println("Thread_name=="+Thread.currentThread().getName());
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });


        executors.addTask(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(1000*4);
                    System.out.println("Thread_name=="+Thread.currentThread().getName());
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }



            }
        });



        System.out.println("主线程等待子线程 执行完毕.............");
        System.out.println("计数器值为："+latch.getCount());
        latch.await();
        System.out.println("主线程结束..........");
        executors.shutdown();




    }


}
