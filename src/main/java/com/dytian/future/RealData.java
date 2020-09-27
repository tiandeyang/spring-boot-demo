package com.dytian.future;

import java.util.concurrent.Callable;

/**
 * @Classname RealData
 * @Description TODO
 * @Date 2019/4/15 10:57
 * @Created by Administrator
 */
public class RealData implements Callable {

    protected String data;

    public RealData(String data) {
        this.data = data;
    }

    @Override
    public Object call() throws Exception {
        Thread.currentThread().sleep(5000);
        return data;
    }
}
