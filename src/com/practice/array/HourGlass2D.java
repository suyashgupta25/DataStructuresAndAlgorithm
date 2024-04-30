package com.practice.array;

import java.util.ArrayList;
import java.util.List;

public class HourGlass2D {
//        1 1 1 0 0 0
//        0 1 0 0 0 0
//        1 1 1 0 0 0
//        0 0 0 0 0 0
//        0 0 0 0 0 0
//        0 0 0 0 0 0

    //    HourGlass2D
//        1 1 1     1 1 0     1 0 0
//          1         0         0
//        1 1 1     1 1 0     1 0 0

    //Find max sum
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        Integer finalSum = 0;
        for (int i = 0; i < arr.size() - 2; i++) {
            List<Integer> firstRow = arr.get(i);
            for (int j = 0; j < firstRow.size() - 2; j++) {
                List<Integer> secondRow = arr.get(i + 1);
                List<Integer> thirdRow = arr.get(i + 2);
                Integer sum = firstRow.get(j) + firstRow.get(j + 1) + firstRow.get(j + 2) + thirdRow.get(j)
                        + thirdRow.get(j + 1) + thirdRow.get(j + 2) + secondRow.get(j+1);
                if(j == 0 && i == 0) {
                    finalSum = sum;
                }
                if(finalSum < sum) {
                    finalSum = sum;
                }
            }
        }
        System.out.println(finalSum);
    }
}
