package com.dytian.testcode.leetcode;

public class FindMaxConsecutiveOnes {


    public int findMaxConsecutiveOnes(int[] nums) {

        int maxNum = 0;
        int secMaxNum = 0;

        int length = nums.length;
        for (int i = 0;i < length;i++){
            int val = nums[i];
            if (val == 1){
                secMaxNum++;
               if (secMaxNum > maxNum){
                   maxNum = secMaxNum;
               }
            }
            if (val == 0){
                secMaxNum = 0;
            }
        }
        return maxNum;

    }


}
