package com.dytian.testcode;


/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {

        int length = digits.length;
        int index = length - 1;
        int incr = 1;

        if (digits[index] < 9){
            digits[index] = digits[index] + 1;
            return digits;
        }

        if (digits.length == 1 && digits[0] == 9){
            return new int[]{1,0};
        }

        while (index > -1){
            if (digits[index] == 9){
                if (incr == 1){
                    if (index == 0){
                        System.out.println(index);
                        digits[index] = 0;
                        int[] ints = new int[length + 1];
                        ints[0] = 1;
                        for (int i =1;i < ints.length;i++){
                            ints[i] = digits[i-1];
                        }
                        return ints;
                    }else {
                        digits[index] = 0;
                        incr = 1;
                    }
                }else {
                    return digits;
                }
            }else {
                digits[index] = digits[index] + incr;
                incr = 0;
            }
            index--;
        }
        return digits;
    }


    public static void main(String[] args) {

        PlusOne plusOne = new PlusOne();
        int[] ints = plusOne.plusOne(new int[]{2,4,9,3,9});
        System.out.println();
        System.out.println(ints.length);

    }

}
