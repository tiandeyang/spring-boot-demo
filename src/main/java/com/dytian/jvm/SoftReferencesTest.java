package com.dytian.jvm;


import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class SoftReferencesTest {

    public static void main(String[] args) {

        // 软引用 只有在虚拟机堆内存空间不足时 才回收 软引用指向的对象
        String str  = new String("abc");
        SoftReference<String> softReference = new SoftReference<>(str);
        str = null;
        System.gc();
        System.out.println(softReference.get());

        // 弱引用 垃圾回收器一旦发现某块内存上只有 弱引用；不管当前内存空间是否足够 都会回收这块内存
        String yes = new String("123");
        WeakReference<String> weakReference = new WeakReference<>(yes);
        yes = null;
        System.gc();
        System.out.println(weakReference.get());


    }

}
