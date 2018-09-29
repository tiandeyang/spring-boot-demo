package com.dytian.testcode.leetcode;


/**
 * In a given integer array nums, there is always exactly one largest element.
 *
 * Find whether the largest element in the array is at least twice as much as every other number in the array.
 *
 * If it is, return the index of the largest element, otherwise return -1.
 */
public class ArrayTest2 {




    public int dominantIndex(int[] nums) {
        int length = nums.length;
        
        if (length < 2){
            return 0;
        }
        int maxIndex = 0;
        int maxValue = 0;
        int secondValu = 0;

        for (int i = 0;i < length;i++ ){
            int value = nums[i];
            if (value > maxValue){
                secondValu = maxValue;
                maxValue = value;
                maxIndex = i;
            }else {
                if (value > secondValu){
                    secondValu = value;
                }
            }
        }

        if (maxValue - secondValu * 2 < 0){
            return -1;
        }
        return maxIndex;
    }


    public static void main(String[] args) {

        ArrayTest2 arrayTest2 = new ArrayTest2();
        int i = arrayTest2.dominantIndex(new int[]{0,0,3,2});
        System.out.println(i);

    }


}
