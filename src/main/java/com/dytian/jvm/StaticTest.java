package com.dytian.jvm;

public class StaticTest
{
   public static void main(String[] args)
   {
        staticFunction();
   }
    // 实例的初始化可能在 类的初始化之前
   static StaticTest st = new StaticTest();


   {
       System.out.println("2");
   }

    static
    {
        System.out.println("1");
    }

   StaticTest()
   {
       System.out.println("3");
       System.out.println("a="+a+",b="+b+",c="+c);
   }

   public static void staticFunction(){
       System.out.println("4");
   }

   int a=110;
   static int b =112;
   static final int c = 100;

}