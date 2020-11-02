package com.dytian.design.pattern.single;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Singleton_v2 {


    private static class LazyHolder{
        private static final Singleton_v2 SINGLETON = new Singleton_v2();
    }

    private Singleton_v2(){};

    public Singleton_v2 getInstance(){
        return LazyHolder.SINGLETON;
    }




    public static void main(String[] args) throws Exception {

        Constructor<Singleton_v2> constructor = Singleton_v2.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        Singleton_v2 singleton_v2 = constructor.newInstance();
        Singleton_v2 singleton_v21 = constructor.newInstance();

        System.out.println(singleton_v2.equals(singleton_v21));
        System.out.println(singleton_v2 == singleton_v21);


    }


//    1.从外部无法访问静态内部类LazyHolder，只有当调用Singleton.getInstance方法的时候，才能得到单例对象INSTANCE。
//    2.INSTANCE对象初始化的时机并不是在单例类Singleton被加载的时候，而是在调用getInstance方法，使得静态内部类LazyHolder被加载的时候。因此这种实现方式是利用classloader的加载机制来实现懒加载，并保证构建单例的线程安全。

}
