package com.dytian.paixu;

import java.util.Arrays;

public class BubbleSort {


    public static void BubbleSort(int[] arr){

        for (int i = 0;i < arr.length - 1;i++){
            int temp ;
            for (int j = 0 ;j < arr.length - i - 1;j++){
                if (arr[j+1] < arr[j]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,6,2,2,5};
        BubbleSort.BubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
