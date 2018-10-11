package com.dytian.utils;


import java.math.BigDecimal;

public class BigDecimals<E> {


    /**
     * @param a
     * @param pattern >,<,=,>=,<=
     * @param b
     * @return
     */
    public boolean compareTo(E a, String pattern, E b) {

        BigDecimal valA = BigDecimal.ZERO;
        BigDecimal valB = BigDecimal.ZERO;

        if (a instanceof Integer) {
            System.out.println("aaa");
            valA = valA.add(new BigDecimal((Integer) a));
            valB = valB.add(new BigDecimal((Integer) b));
        }

        if (a instanceof BigDecimal) {
            valA = valA.add((BigDecimal) a);
            valB = valB.add((BigDecimal) b);
        }

        if (pattern.equals(">")) {
            return valA.compareTo(valB) > 0;
        }
        if (pattern.equals(">=")) {
            return valA.compareTo(valB) >= 0;
        }
        if (pattern.equals("<")) {
            return valA.compareTo(valB) < 0;
        }
        if (pattern.equals("<=")) {
            return valA.compareTo(valB) <= 0;
        }
        if (pattern.equals("=")) {
            return valA.compareTo(valB) == 0;
        }
        throw new IllegalArgumentException(pattern + " 参数非法");
    }

    public static BigDecimals Instance() {
        return new BigDecimals();
    }

    public static void main(String[] args) {

        BigDecimal a = new BigDecimal("20.");
        BigDecimal b = new BigDecimal("20.2");
        Integer a1 = 100;
        Integer a2 = 100;

        boolean b3 = BigDecimals.Instance().compareTo(a1, "<", a2);

   //     System.out.println(b2);
        System.out.println(b3);

    }


}
