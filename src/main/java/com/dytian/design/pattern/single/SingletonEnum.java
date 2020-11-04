package com.dytian.design.pattern.single;

public enum SingletonEnum {

    // 单例模式
    INSTANCE;

    public void dosomething(){
        System.out.println("hello world to do sth else !!!!");
    }


    public static void main(String[] args) {
        // 一行代码搞定 是不是很优雅
        SingletonEnum.INSTANCE.dosomething();
    }
    

}
