package com.dytian.utils;


import java.math.BigDecimal;

public class BigDecimals {

    /**
     *
     * @param a
     * @param pattern >,<,=,>=,<=
     * @param b
     * @return
     */
    public static boolean compareTo(BigDecimal a,String pattern,BigDecimal b){

        if (pattern.equals(">")){
            return a.compareTo(b) > 0;
        }
        if (pattern.equals(">=")){
            return a.compareTo(b) >= 0;
        }
        if (pattern.equals("<")){
            return a.compareTo(b) < 0;
        }
        if (pattern.equals("<=")){
            return a.compareTo(b) <= 0;
        }
        if (pattern.equals("=")){
            return a.compareTo(b) == 0;
        }
        throw new IllegalArgumentException(pattern+" 参数非法");
    }


    public static void main(String[] args) {

        BigDecimal a = new BigDecimal("20.23");
        BigDecimal b = new BigDecimal("20.2");

        boolean b1 = BigDecimals.compareTo(b, "**", a);
        System.out.println(b1);

    }


}
