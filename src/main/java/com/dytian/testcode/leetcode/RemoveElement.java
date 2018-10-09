package com.dytian.testcode.leetcode;

public class RemoveElement {


    public int removeElement(int[] nums, int val) {

        int length = nums.length;
        int k = 0;
        for (int i = 0;i < length;i++){
            int currVal = nums[i];
           if (currVal != val){
               nums[k] = nums[i];
               k++;
           }
        }
        return k;
    }


}
