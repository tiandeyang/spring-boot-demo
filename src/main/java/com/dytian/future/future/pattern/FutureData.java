package com.dytian.future.future.pattern;

/**
 * @Classname FutureData
 * @Description TODO
 * @Date 2019/4/15 11:41
 * @Created by Administrator
 */
public class FutureData implements Data {

    RealData realData = null;

    private volatile boolean isReady = false;

    public synchronized void setRealData(RealData realData){
        if (isReady) return;
        this.realData = realData;
        isReady = true;
        notifyAll();
    }

    @Override
    public synchronized String getData() throws InterruptedException {
        if (!isReady){
            wait();
        }
        return realData.getData();
    }

    @Override
    public void addOnCompleteListener(OnCompleteListener listener) {
        realData.addOnCompleteListener(listener);
    }
}
