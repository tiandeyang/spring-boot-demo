package com.dytian.testcode;

import io.swagger.models.auth.In;
import org.nutz.json.Json;

import java.util.ArrayList;

public class AddBinary {



    public String addBinary(String a, String b) {

        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();

        int a_len = ca.length;
        int b_len = cb.length;

        int jinwei = 0;

        int min_len = a_len > b_len?b_len:a_len;
        int max_len = a_len > b_len?a_len:b_len;
        int span = max_len - min_len;

        ArrayList<Integer> integers = new ArrayList<>();

        for (int i = min_len - 1;i > -1;i--){
            int a_int = 0;
            int b_int = 0;
            if (ca.length > cb.length){
                 a_int = charToInt(ca[i+span]);
                 b_int = charToInt(cb[i]);
            }
            if (ca.length < cb.length){
                a_int = charToInt(ca[i]);
                b_int = charToInt(cb[i+span]);
            }
            if (ca.length == cb.length){
                a_int = charToInt(ca[i]);
                b_int = charToInt(cb[i]);
            }
            System.out.println("a==="+a_int);
            System.out.println("b===="+b_int);
            int sum = 0;
            if (a_int + b_int + jinwei == 2){
                sum = 0;
                jinwei = 1;
            }else if (a_int + b_int + jinwei == 1){
                sum = 1;
                jinwei = 0;
            }else if (a_int + b_int + jinwei == 3){
                sum = 1;
                jinwei = 1;
            }else {
                sum = 0;
                jinwei = 0;
            }
            System.out.println("sum==="+sum);
            integers.add(sum);
        }
      //  System.out.println(Json.toJson(integers));
        System.out.println("jinwei==="+jinwei);
        if (span == 0){
            if (jinwei == 1){
                integers.add(jinwei);
            }
        }else {
            char[] chars = ca.length > cb.length ? ca : cb;
            System.out.println("span==="+span);
            for (int i = span;i > 0 ;i--){
                if (charToInt(chars[i-1]) + jinwei == 2){
                    integers.add(0);
                    jinwei = 1;
                }else if (charToInt(chars[i-1]) + jinwei == 1){
                    integers.add(1);
                    jinwei = 0;
                }else {
                    integers.add(0);
                    jinwei = 0;
                }
            }
            if (jinwei == 1){
                integers.add(1);
            }
        }

        System.out.println("size==="+integers.size());
       StringBuffer buffer = new StringBuffer(integers.size());
        int size = integers.size();
        for (int i = size;i > 0;i--){
            buffer.append(integers.get(i-1));
        }
        return buffer.toString();
    }



    private int charToInt(char c){
        Integer integer = Integer.valueOf(c);
        if (integer.equals(49))
            return 1;
        else
            return 0;
    }



    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        String s = addBinary.addBinary("100", "110010");
        System.out.println(s);
    }


}
