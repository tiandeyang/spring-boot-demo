package com.dytian.java;


import org.nutz.json.Json;

public class FinalTest {


    public void dealInner(final Inner inner){
        inner.setName("halle");
        Inner secondTime = new Inner("secondi");
      //  inner = secondTime;   final 修饰的 引用类型变量是不可更换的  但是其值可以改变
        System.out.println("hello");
        System.out.println(Json.toJson(inner));
    }


    static class Inner{
        String name = "my anme";

        public Inner(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }


    public static void main(String[] args) {

        Inner inner = new Inner("tdy");
        Inner inner1 = new Inner("atc");
        FinalTest finalTest = new FinalTest();

        finalTest.dealInner(inner);
        finalTest.dealInner(inner1);

    }

}
