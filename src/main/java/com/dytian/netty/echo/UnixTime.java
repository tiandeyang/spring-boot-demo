package com.dytian.netty.echo;

import java.io.Serializable;

public class UnixTime implements Serializable {

    private final long value;


    public UnixTime(long value) {
        this.value = value;
    }


    public UnixTime() {
        this(System.currentTimeMillis() / 1000);
    }


    public long getValue() {
        return value;
    }
}
