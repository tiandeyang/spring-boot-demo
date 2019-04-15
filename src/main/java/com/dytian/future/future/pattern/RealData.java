package com.dytian.future.future.pattern;

/**
 * @Classname RealData
 * @Description TODO
 * @Date 2019/4/15 11:40
 * @Created by Administrator
 */
public class RealData implements Data
{

    String data;
    OnCompleteListener listener;

    public RealData(String data) {
        this.data = data;
    }

    @Override
    public String getData() throws InterruptedException {
        Thread.currentThread().sleep(5*1000);
        listener.onComplete("data is ok:"+data);
        return data;
    }

    @Override
    public void addOnCompleteListener(OnCompleteListener listener) {
        this.listener = listener;
    }
}
