package com.dytian.testcode;

import io.swagger.models.auth.In;
import org.nutz.json.Json;

import java.util.ArrayList;
import java.util.List;

public class YanghuiSanjiao {


    private List<List<Integer>> yanghui ;

    public List<List<Integer>> generate(int numRows) {
        yanghui = new ArrayList<>(numRows);

        for (int i = 0;i < numRows;i++){
            List<Integer> integers = new ArrayList<>(i + 1);
            if (i == 0){
                integers.add(1);
                yanghui.add(integers);
                continue;
            }
            if (i == 1){
                integers.add(1);
                integers.add(1);
                yanghui.add(integers);
                continue;
            }
            for (int j = 0;j < i + 1;j++){
                if (j == 0){
                    integers.add(1);
                    continue;
                }
                if (j == i ){
                    integers.add(1);
                    continue;
                }
                List<Integer> higher = yanghui.get(i - 1);
                int sum = higher.get(j) + higher.get(j - 1);
                integers.add(sum);
            }
            yanghui.add(integers);
        }
        return yanghui;
    }

    public static void main(String[] args) {
        YanghuiSanjiao yanghuiSanjiao = new YanghuiSanjiao();
        List<List<Integer>> generate = yanghuiSanjiao.generate(5);
        System.out.println(Json.toJson(generate));


    }



}
