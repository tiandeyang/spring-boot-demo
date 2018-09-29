package com.dytian.testcode.leetcode;

public class StrStr {


    int position = -1;

    public int strStr(String haystack, String needle) {

        if (needle.equals("")){
            return 0;
        }

        if (needle.length()>haystack.length()){
            return -1;
        }

        if (haystack.equals(needle)){
            return 0;
        }

        char[] c_needle = needle.toCharArray();
        char[] c_hay = haystack.toCharArray();

        char head = c_needle[0];
        int heand_int = charToInt(head);
        int len_needle = c_needle.length;

        for (int i = 0;i < c_hay.length;i++){
            char c = c_hay[i];
            int temp_int = charToInt(c);

            if (temp_int != heand_int){
                continue;
            }
            if (len_needle > c_hay.length - i ){
                return  -1;
            }
            System.out.println("i==="+i);
            int flag = 0;
            for (int j = 0;j < len_needle;j++){

                int i1 = charToInt(c_needle[j]);
                int i2 = charToInt(c_hay[i + j]);
                if (i1 != i2){
                    flag = 1;
                    break;
                }
            }
            System.out.println("flag===="+flag);
            if (flag == 1){
                continue;
            }
            position = i;
            break;
        }
        return position;
    }


    private int charToInt(char c){
        Integer integer = Integer.valueOf(c);
        return integer;
    }


    public static void main(String[] args) {

      /*  "mississippi"
        "pi"*/

        StrStr strStr = new StrStr();
        int i = strStr.strStr("mississippi", "pi");
        System.out.println(i);
    }

}
