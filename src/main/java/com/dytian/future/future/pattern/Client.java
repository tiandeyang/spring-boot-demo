package com.dytian.future.future.pattern;

/**
 * @Classname Client
 * @Description TODO
 * @Date 2019/4/15 11:52
 * @Created by Administrator
 */
public class Client  {


    public Data request(String data){

        FutureData futureData = new FutureData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                futureData.setRealData(new RealData(data));
            }
        }).start();
        return futureData;


//        RealData futureData = new RealData(data);
////        new Thread(new Runnable() {
////            @Override
////            public void run() {
////                futureData.setRealData(new RealData(data));
////                futureData.addOnCompleteListener(Client.this);
////            }
////        }).start();

 //       return futureData;

    }

    public static void main(String[] args) throws InterruptedException {

        Data dytian = new Client().request("dytian");
        System.out.println("请求完 立马返回....");
        dytian.addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(String data) {
                System.out.println("OnComplete====data==="+data);
            }
        });

//        System.out.println("阻塞...");
//        String data = dytian.getData();

//        System.out.println("阻塞结束 打印结果如下:");
//        System.out.println(data);

    }



}
