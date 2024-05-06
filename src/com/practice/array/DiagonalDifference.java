package com.practice.array;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
public class DiagonalDifference {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        List<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        List<Integer> arr2 = new ArrayList<>();
        arr2.add(4);
        arr2.add(5);
        arr2.add(6);
        List<Integer> arr3 = new ArrayList<>();
        arr3.add(7);
        arr3.add(8);
        arr3.add(9);
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(arr1);
        arr.add(arr2);
        arr.add(arr3);
        System.out.println(diagonalDifference(arr));
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int size = arr.size();
        int d1 = 0;
        int d2 = 0;
        for (int i = 0; i < size; i++) {
            List<Integer> integers = arr.get(i);
            Integer first = integers.get(i);
            Integer last = integers.get(size - i - 1);
            d1 = d1 + first;
            d2 = d2 + last;
        }
        return Math.abs(d1-d2);
    }
}
