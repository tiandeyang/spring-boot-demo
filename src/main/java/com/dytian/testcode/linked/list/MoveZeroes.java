package com.dytian.testcode.linked.list;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        int length = nums.length;
        int zeroNum = 0;
        int validIndex = 0;
        for (int i = 0;i < length;i++){
            int val = nums[i];
            if (val != 0){
                nums[validIndex++] = val;
            }else {
                zeroNum++;
            }
        }

        int tail = length - 1;
        for (int i = 0;i < zeroNum;i++){
            nums[tail--] = 0;
        }

    }

}
