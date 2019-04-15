package com.dytian.future.future.pattern;

/**
 * @Classname Data
 * @Description TODO
 * @Date 2019/4/15 11:16
 * @Created by Administrator
 */
public interface Data {

    String getData() throws InterruptedException;

    void addOnCompleteListener(OnCompleteListener listener);

}
