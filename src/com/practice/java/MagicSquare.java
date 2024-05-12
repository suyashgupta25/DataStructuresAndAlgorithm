package com.practice.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MagicSquare {

    public static void main(String[] args) {
//        formingMagicSquare()
    }

    public static int formingMagicSquare(List<List<Integer>> s) {
        int sum = 0;
        boolean isFirst = true;
        //find all
        List<int[][]> list = generate();
        //find min
        for (int[][] ints : list) {
            int total = 0;
            for (int i = 0; i < 3; i++) {
                for (int i1 = 0; i1 < 3; i1++) {
                    total += Math.abs(ints[i][i1] - s.get(i).get(i1));
                }
            }
            if (isFirst){
                sum = total;
                isFirst = false;
            } else {
                sum = Math.min(sum, total);
            }
        }
        return sum;
    }

    private static List<int[][]> generate() {
        Stack<int[][]> numList = new Stack<>();
        int[][] square = {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}};
        //rotate
        int du = 270;
        while (du >= 0) {
            int[][] square1 = new int[3][3];
            if (!numList.isEmpty()) {
                square = numList.peek();
            }
            for (int i = 0; i < 3; i++) {
                for (int i1 = 0; i1 < 3; i1++) {
                    square1[i][i1] = square[2 - i1][i];
                }
            }
            numList.push(square1);
            du -= 90;
        }
        List<int[][]> list = new ArrayList(7);
        //find left => right
        numList.forEach(a ->{
            int[][] square1 = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int i1 = 0; i1 < 3 ; i1++) {
                    square1[i][i1] = a[i][2 - i1];
                }
            }
            list.add(square1);
        });
        numList.addAll(list);
        return numList;
    }
}
