package com.dytian.design.pattern.single;

/**
 * 饿汉式
 */
public class SingletonHungery {

    private static SingletonHungery instance = new SingletonHungery();

    private SingletonHungery(){};

    public static SingletonHungery getInstance(){
        return instance;
    }


}
