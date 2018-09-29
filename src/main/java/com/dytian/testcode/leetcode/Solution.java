package com.dytian.testcode.leetcode;


import java.util.HashMap;
import java.util.Map;


/**
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
 *
 * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 */
class Solution {

    private Map<Integer,Integer> container = new HashMap<>();

    public int pivotIndex(int[] nums) {

        int length = nums.length;
        if (length < 3){
            return -1;
        }
        int index = 0;
        int centerIndex = - 1;

        int total = total(nums);

        while (true){
            if (index < 0 || index == length){
                centerIndex = -1;
                break;
            }
            int leftSum = leftSum(nums, index);
            int rightSum = rightSum(leftSum,total,nums, index);
            if (leftSum == rightSum){
                centerIndex = index;
                break;
            }
           index++;
        }
        container.clear();
        return centerIndex;
    }


    private int leftSum(int[] nums,int index){
        if (container.containsKey(index-2)){
            Integer integer = container.get(index - 2);
            return integer + nums[index-1];
        }
        int leftSum = 0;
        for (int i = 0; i < index ;i++){
            leftSum = leftSum + nums[i];
        }
        container.put(index - 1,leftSum);
        return leftSum;
    }


    private int rightSum(int leftSum,int total,int[] nums,int index){
        return total - leftSum - nums[index];
    }

    private int total(int[] nums){
        int length = nums.length;
        int total = 0;
        for (int i =0 ;i < length;i++){
            total = total + nums[i];
        }
        return total;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.pivotIndex(new int[]{-1, -1, -1, -1, -1, 0});
        System.out.println(i);
    }

}