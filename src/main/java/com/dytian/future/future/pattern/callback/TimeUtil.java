package com.dytian.future.future.pattern.callback;

/**
 * @Classname TimeUtil
 * @Description TODO
 * @Date 2019/4/15 14:28
 * @Created by Administrator
 */
public class TimeUtil {

    TimeListener listener;

    public TimeUtil(TimeListener listener) {
        this.listener = listener;
    }


    public String getTime(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(8*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                listener.getTime("当前时间是 2018");
            }
        }).start();

        return null;
    }

}
