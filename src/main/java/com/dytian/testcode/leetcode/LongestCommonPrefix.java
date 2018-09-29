package com.dytian.testcode.leetcode;

public class LongestCommonPrefix {



    public String longestCommonPrefix(String[] strs) {

        int length = strs.length;
        if (length == 0){
            return "";
        }
        if (length == 1){
            return strs[0];
        }
        if (strs[0].equals("")){
            return "";
        }
        String str = strs[0];
        char[] chars = str.toCharArray();

        String s = String.valueOf(chars[0]);

        String longestCommonPrefix = "";

        boolean flag = true;
        int startIndex = 0;
        int endIndex = 0;
        for (int j = 0;j < chars.length;j++){
            String subStr = getSubStr(chars, startIndex,endIndex);

            for (int i = 1;i < length;i++ ){
                if (!flag){
                    return longestCommonPrefix;
                }
                String str1 = strs[i];
                // System.out.println("str==="+str1);
                // System.out.println("subStr==="+subStr);
                if (!str1.startsWith(subStr)){
                  flag = false;
                }
            }
            // System.out.println("flag==="+flag);
            if (flag){
                endIndex++;
                longestCommonPrefix = subStr;
            }
        }
        return longestCommonPrefix;
    }

    private String getSubStr(char[] chars,int startIndex,int endIndex){
        StringBuffer buffer = new StringBuffer();
        for (int i = 0;i < chars.length;i++){
            if (i < startIndex){
                continue;
            }
            if (i > endIndex){
                continue;
            }
            String s = String.valueOf(chars[i]);
            buffer.append(s);
        }
        return buffer.toString();
    }

    public static void main(String[] args) {

        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String s = longestCommonPrefix.longestCommonPrefix(new String[]{"c", "acc", "ccc"});
        // System.out.println("-----------"+s);

    }


}
