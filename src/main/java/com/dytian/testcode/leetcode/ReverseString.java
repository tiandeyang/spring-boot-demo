package com.dytian.testcode.leetcode;

public class ReverseString {


    public String reverseString1(String s) {

        if (s.length() == 0){
            return "";
        }
        char[] chars = s.toCharArray();
        System.out.println(chars.length);
        int length = chars.length;

        int middle = length / 2;
        if (length % 2 == 0){
            middle = length / 2 - 1;
        }
        int endIndex = length - 1;

        for (int i = 0;i <= middle;i++ ){
            char temp = chars[i];
            chars[i] =  chars[endIndex];
            chars[endIndex] = temp;
            endIndex--;
        }

        System.out.println(chars.length);

        return new String(chars);
    }


    public String reverseString(String s) {

        if (s.length() == 0){
            return "";
        }
        char[] chars = s.toCharArray();
        int length = chars.length;
        int startIndex = 0;
        int endIndex = length - 1;

        while (true){

            if (startIndex == endIndex || startIndex == endIndex + 1){
                break;
            }
            char temp = chars[startIndex];
            chars[startIndex] = chars[endIndex];
            chars[endIndex] = temp;

            startIndex++;
            endIndex--;

        }

        return new String(chars);
    }


    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
    }

}
