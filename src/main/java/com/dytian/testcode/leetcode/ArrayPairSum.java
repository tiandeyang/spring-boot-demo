package com.dytian.testcode.leetcode;

import java.util.Arrays;

public class ArrayPairSum {


    public int arrayPairSum(int[] nums) {

        if (nums.length == 0){
            return 0;
        }

//        int length = nums.length;
//        for (int i = length - 1 ;i >= 0;i--){
//            for (int j = 0;j < i;j++){
//                if (nums[j+1] < nums[j]){
//                    int temp = nums[j+1];
//                    nums[j+1] = nums[j];
//                    nums[j] =temp;
//                }
//            }
//        }
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0;i < nums.length;i+=2){
            sum+=nums[i];
        }
        return sum;
    }


}
