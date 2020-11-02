package com.dytian.design.pattern.single;

public class Singleton {

    private Singleton() {

    }


    private volatile static Singleton instance = null;

    public Singleton getInstance(){

        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


}
