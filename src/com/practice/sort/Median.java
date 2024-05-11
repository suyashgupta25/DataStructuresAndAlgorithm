package com.practice.sort;

import java.util.List;

public class Median {

    public static int findMedian(List<Integer> list) {
//        Collections.sort(list);
        Integer[] arr = list.toArray(new Integer[list.size()]);
        for (int i = 1; i < arr.length; i++) {
            Integer element = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > element) {
                arr[j+1] = arr[j];
                --j;
            }
            arr[j+1] = element;
        }
        return arr[list.size()/2];
    }
}
