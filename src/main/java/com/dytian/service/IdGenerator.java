package com.dytian.service;

import com.dytian.mapper.User_accountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Classname IdGenerator
 * @Description TODO
 * @Date 2019/5/20 10:35
 * @Created by Administrator
 */
@Service
public class IdGenerator {



    private SequenceIdFetch sequenceIdFetch;


    public SequenceIdFetch getSequenceIdFetch() {
        return sequenceIdFetch;
    }

    public void setSequenceIdFetch(SequenceIdFetch sequenceIdFetch) {
        this.sequenceIdFetch = sequenceIdFetch;
    }



    private static final String TABLE = "yuemee_sequ";
    private  volatile AtomicLong atomicLong = new AtomicLong(1);
    private  long MAXID = 0l;
    private static final int STEP = 4000;
    private static final ArrayBlockingQueue<IdOpjo> splitQuene = new ArrayBlockingQueue(32);

    private static Thread idWorker ;

    //



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




}
