package com.dytian.testcode.leetcode;

/**
 * M*N
 * 思路剖析
 * 从 0,0 开始   横坐标  为 0 ,则 N = N + 1
 * 纵坐标 为 0 则 M = M + 1
 */
public class FindDiagonalOrder {

    int m = 0;
    int n = 0;
    int  arrowDerection = 0;

    /**
     *
     * @param matrix
     * @return
     */

    public int[] findDiagonalOrder(int[][] matrix) {

        // System.out.println("length==="+matrix.length);
        // System.out.println("2_length==="+matrix[0].length);


        if (matrix.length == 0){
            return new int[]{};
        }

        if (matrix.length == 1){
            return matrix[0];
        }

        int[] result = new int[matrix.length*matrix[0].length];
        if (matrix[0].length == 1){
            for (int i = 0;i < matrix.length;i++){
                result[i] = matrix[i][0];
            }
            return result;
        }


        int mMax = matrix.length - 1;
        int nMax = matrix[0].length - 1;

        int index = 0;

        while (m <= mMax || n <= nMax){
            // System.out.println("m=="+m);
            // System.out.println("n==="+n);
            int value = matrix[m][n];
            // System.out.println("value=="+value);
            result[index] = value;
            index++;
            // System.out.println("index========="+index);
            // System.out.println("derection===="+arrowDerection);

            if (m == 0 && n == 0){
                // System.out.println("11111111111111");
                toRight();
                changeDerection();
                // System.out.println("11-derection=="+arrowDerection);
                continue;
            }

            if (m == 0 && n > 0){

                if (n == nMax){
                    if (isRightUp()){
                        toDown();
                        changeDerection();
                        // System.out.println("22222222222221111111111111111");
                        continue;
                    }
                    if (isLeftDown()){
                        toLeftDown();
                        // System.out.println("2222222222222---555555555555555555555");
                        continue;
                    }

                }

                if (n < nMax){

                    if (isRightUp()){
                        toRight();
                        changeDerection();
                        // System.out.println("000000000000000000000000");
                        continue;
                    }

                    if (isLeftDown()){
                        toLeftDown();
                        // System.out.println("2222222222222---22222222222222");
                        continue;
                    }

                }

            }

            if (m > 0 && n == 0){
                // System.out.println("33333333333333");
                if (m == mMax){
                    if (isLeftDown()){
                        toRight();
                        changeDerection();
                        // System.out.println("3------------1");
                        continue;
                    }
                    if (isRightUp()){
                        toRightUp();
                        // System.out.println("3-------------2");
                        continue;
                    }
                }

                if (m < mMax){
                    if (isLeftDown()){
                        toDown();
                        changeDerection();
                        // System.out.println("3-------------3");
                        continue;
                    }
                    if (isRightUp()){
                        toRightUp();
                        // System.out.println("3-------------4");
                        continue;
                    }
                }
            }

            if (m == mMax && n > 0 && n < nMax){
                // System.out.println("4444444444444");
                if (isLeftDown()){
                    toRight();
                    changeDerection();
                    // System.out.println("4-----------------1");
                    continue;
                }
                if (isRightUp()){
                    toRightUp();
                    // System.out.println("4-----------------2");
                    continue;
                }
                continue;
            }

            if (m > 0  && m < mMax  && n == nMax){
                // System.out.println("5555555555555555555");
                if (isRightUp()){
                    toDown();
                    changeDerection();
                    // System.out.println("5----------------1");
                    continue;
                }
                if (isLeftDown()){
                   toLeftDown();
                    // System.out.println("5------------------2");
                   continue;
                }
            }

            if ( n == nMax && m == mMax){
                // System.out.println("666666666666666666666");
               break;
            }

            if (isLeftDown()){
                toLeftDown();
                // System.out.println("7777777777777777777777777");
                continue;
            }

            if (isRightUp()){
                toRightUp();
                // System.out.println("8888888888888888");
                continue;
            }

        }


        return result;
    }



    private void toRight(){
        n++;
    }

    private void toDown(){
        m++;
    }

    private void toRightUp(){
        m--;
        n++;
    }

    private void toLeftDown(){
        m++;
        n--;
    }

    private boolean isRightUp(){
        return arrowDerection == 0;
    }

    private boolean isLeftDown(){
        return arrowDerection == 1;
    }

    private void changeDerection(){
        if (arrowDerection == 0){
            arrowDerection = 1;
            // System.out.println("arr=="+arrowDerection);
            return;
        }

        if (arrowDerection == 1){
            arrowDerection = 0;
            return;
        }
    }

    public static void main(String[] args) {
        FindDiagonalOrder findDiagonalOrder = new FindDiagonalOrder();
  //      int[][]  twoArray = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][]  twoArray = new int[][]{{2},{3}};
        int[] diagonalOrder = findDiagonalOrder.findDiagonalOrder(twoArray);
        // System.out.println("arr=="+Json.toJson(diagonalOrder));
    }

}
