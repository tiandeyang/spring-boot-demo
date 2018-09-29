package com.dytian.testcode.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 */
public class SpiralOrder {

    private int arrDerection = 0;
    private int m;
    private int n;

    private int mMax ;
    private int nMax;

    private int index;
    private int total;

    private Map<String,String> container ;


    public List<Integer> spiralOrder(int[][] matrix) {

        int length = matrix.length;
        if (length == 0) {
            return new ArrayList<>();
        }
        if (length == 1) {
            int[] subMatrix = matrix[0];
            List<Integer> integers = new ArrayList<>(subMatrix.length);
            for (int i = 0; i < subMatrix.length; i++) {
                integers.add(subMatrix[i]);
            }
            return integers;
        }

        if (matrix[0].length == 1){
            List<Integer> integers = new ArrayList<>(length);
            for (int i = 0;i < length;i++){
                int i1 = matrix[i][0];
                integers.add(i1);
            }
            return integers;
        }

        container = new HashMap<>(length * matrix[0].length);
        ArrayList<Integer> integers = new ArrayList<>(length * matrix[0].length);
        total = length * matrix[0].length;
        mMax = length - 1;
        nMax = matrix[0].length - 1;
        total = length * matrix[0].length;



        while (true){
            // System.out.println("m==="+m);
            // System.out.println("n===="+n);

            int value = matrix[m][n];
            integers.add(value);
            container.put(m+","+n,value+"");
            index++;
            int temp_m = m;
            int temp_n = n;
            if (!isFull()){
                if (isToRight()){
                    // System.out.println("toRight==11111111111");

                        temp_n++;
                        String key = temp_m+","+temp_n;

                        if (container.containsKey(key)){
                            changeToDown();
                            moveToDown();
                        }else if (getReghted()){
                            changeToDown();
                            moveToDown();
                        }else {
                            moveToRight();
                        }
                        continue;
                }
                if (isToDown()){
                    // System.out.println("222222222222222");
                    temp_m++;
                    String key = temp_m+","+temp_n;

                    if (container.containsKey(key)){
                        changeToLeft();
                        moveToLeft();
                    }else if (getBotomm()){
                        changeToLeft();
                        moveToLeft();
                    }else {
                        moveToDown();
                    }

                    continue;
                }
                if (isToLeft()){

                    // System.out.println("3333333333333");
                    temp_n--;
                    String key = temp_m+","+temp_n;

                    if (container.containsKey(key)){
                        changeToUp();
                        moveToUp();
                    }else if (getLefted()){
                        changeToUp();
                        moveToUp();
                    }else {
                        moveToLeft();
                    }
                    continue;
                }
                if (isToUp()){
                    // System.out.println("444444444444444");
                    temp_m--;
                    String key = temp_m+","+temp_n;
                    if (container.containsKey(key)){
                        changeToRight();
                        moveToRight();
                    }else  {
                        moveToUp();
                    }
                    continue;
                }

            }
            break;
        }


        return integers;

    }

    private void moveToRight(){
        n++;
    }

    private void moveToDown(){
        m++;
    }

    private void moveToLeft(){
        n--;
    }

    private void moveToUp(){
        m--;
    }

    private boolean isFull(){
        return index == total;
    }

    private boolean getReghted(){
        return n == nMax;
    }

    private boolean getBotomm(){
        return m == mMax;
    }

    private boolean getLefted(){
        return n == 0;
    }




    private void changeToLeft(){
        arrDerection = 2 ;
    }
    private void changeToDown(){
        arrDerection = 1 ;
    }

    private void changeToRight(){
        arrDerection = 0 ;
    }


    private void changeToUp(){
        arrDerection = 3;
    }

    private boolean isToLeft(){
        return arrDerection == 2;
    }
    private boolean isToDown(){
        return arrDerection == 1;
    }

    private boolean isToRight(){
        return arrDerection == 0;
    }

    private boolean isToUp(){
        return arrDerection == 3;
    }




    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        List<Integer> integers = spiralOrder.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        // System.out.println(Json.toJson(integers));
    }

}
