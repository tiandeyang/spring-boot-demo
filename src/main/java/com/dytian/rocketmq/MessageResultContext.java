package com.dytian.rocketmq;

public class MessageResultContext {


    public boolean isOK;

    public MessageResultContext(boolean isOK) {
        this.isOK = isOK;
    }


    public boolean isOK() {
        return isOK;
    }

    public void setOK(boolean OK) {
        isOK = OK;
    }
}
