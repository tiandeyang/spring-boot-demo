package com.dytian.future.future.pattern.listenable.future;

import com.google.common.util.concurrent.FutureCallback;

/**
 * @Classname FutureCallBackImp
 * @Description TODO
 * @Date 2019/4/15 15:15
 * @Created by Administrator
 */
public class FutureCallBackImp implements FutureCallback {

    @Override
    public void onSuccess(Object result) {
        System.out.println("reslut=================="+result.toString());
    }

    @Override
    public void onFailure(Throwable t) {

    }
}
