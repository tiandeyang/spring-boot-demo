package com.dytian.testcode.leetcode;

import java.util.Arrays;

public class TwoSum {


    public int[] twoSum(int[] numbers, int target) {

        int length = numbers.length;
        int leftIndex = 0;
        int rightIndex = length - 1;

        int[] ints =new int[2];

        while (true){
            if (leftIndex == rightIndex){
                break;
            }
            int leftValue = numbers[leftIndex];
            int rightValue = numbers[rightIndex];
            if (leftValue + rightValue == target){
                ints[0] = leftIndex + 1;
                ints[1] = rightIndex + 1;
                break;
            }
            if (leftValue + rightValue > target){
                rightIndex--;
            }
            if (leftValue + rightValue < target){
                leftIndex++;
            }
        }

        return ints;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ints));
    }


}
