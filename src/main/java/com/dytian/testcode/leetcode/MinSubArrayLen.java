package com.dytian.testcode.leetcode;

public class MinSubArrayLen {



    public int minSubArrayLen(int s, int[] nums) {
        //2,3,1,2,4,3

        // 退出循环的条件   最小长度 为 1  则退出; 循环结束则退出;

        int length = nums.length;
        int currIndex  = 0;
        int minLen = length;
        int sum = 0;
        int mark = 0;

        while (true){
            if (currIndex == length)
                break;

             sum = sum + nums[currIndex];
             System.out.println("s=="+sum);
             if (sum >= s){
                 System.out.println("sum==="+sum);
                 int currLen = currIndex - mark + 1;
                 if (currLen == 1){
                     minLen = 1;
                     break;
                 }
                 if (currLen < minLen){
                     minLen = currLen;
                     mark = currIndex;
                     sum = 0;
                 }

             }else {
                 currIndex++;
             }
        }
        return minLen;
    }

    public static void main(String[] args) {

        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        int i = minSubArrayLen.minSubArrayLen(7, new int[]{2,3,1,2,4,3});
        System.out.println("minLen==="+i);

    }

}
