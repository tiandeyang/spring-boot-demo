package com.dytian.timer;


import io.netty.util.Timeout;
import io.netty.util.TimerTask;
import org.nutz.log.Log;
import org.nutz.log.Logs;

/**
 * @Classname Task
 * @Description TODO
 * @Date 2019/4/22 15:02
 * @Created by Administrator
 */
public class Task implements TimerTask {

    Log log = Logs.getLog(Task.class);

    @Override
    public void run(Timeout timeout) throws Exception {
     //   System.out.println("task executed !!!!");
        log.info("task executed !!!!");
    }


}
