package com.dytian.idGenerater;


import com.dytian.aspect.cache.SpringUtil;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;


@Component
public class IdGenerater implements Runnable{



    private  volatile AtomicLong atomicLong = new AtomicLong(1);
    private  long MAXID = 0l;
    private static final int STEP = 4000;
    private static final ArrayBlockingQueue<IdOpjo> splitQuene = new ArrayBlockingQueue(64);

    private static Thread idWorker ;
   // private static IdGenerater  idGenerater ;


//    @PostConstruct //通过@PostConstruct实现初始化bean之前进行的操作
//    public void init() {
//        idGenerater = this;
//        // 初使化时将已静态化的testService实例化
//    }


    public IdGenerater(){
        idWorker = new Thread(this);
        idWorker.start();
    }

    /**
     * synchronized 相比  reentrantLock 效率更高些
     * @return
     */
    public synchronized  long generator() {

        long curr = atomicLong.getAndIncrement();
        if (curr < MAXID){
            return curr;
        }
        IdOpjo poll = null;
        try {
            poll = splitQuene.poll(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // get the core of china;of spirit of china;
        long maxid = poll.getMaxid();
        long maxid_ahead = poll.getMaxid_ahead();

        atomicLong.set(maxid);
        MAXID = maxid_ahead;

        return atomicLong.getAndIncrement();
    }

    private int getMaxId(){
        MysqlIdGeter idGeter = SpringUtil.getBean(MysqlIdGeter.class);
        return idGeter.getId();
    }


    private IdOpjo resetMaxId() {
        int maxId = getMaxId();
        int maxStep = maxId * STEP;
        long max = (maxId + 1) * STEP;
        return new IdOpjo(maxStep, max);
    }
    // u

    class IdOpjo{

        long maxid;
        long maxid_ahead;
        public IdOpjo(long maxid, long maxid_ahead) {
            this.maxid = maxid;
            this.maxid_ahead = maxid_ahead;
        }
        public long getMaxid() {
            return maxid;
        }

        public void setMaxid(long maxid) {
            this.maxid = maxid;
        }


        public long getMaxid_ahead() {
            return maxid_ahead;
        }

        public void setMaxid_ahead(long maxid_ahead) {
            this.maxid_ahead = maxid_ahead;
        }

    }

    @Override
    public void run() {

        while (true){
            IdOpjo idOpjo = resetMaxId();
            try {
                splitQuene.put(idOpjo);
              //  System.out.println("put 成功。。。。。。。。。。。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
