package com.practice.sort;

import java.util.*;
import java.util.stream.Collectors;

public class Insertion {

    public static void insertionSortFix(Integer[] array){
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = temp;
        }
        printArray(array);
    }

    static void printArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int count = scanner.nextInt();
//        scanner.nextLine();
//        String line = scanner.nextLine();
//        String[] strings = line.split(" ");
//        List<Integer> list = Arrays
//                .stream(strings)
//                .map(Integer::parseInt)
//                .toList();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(2);

        insertionSortFix(list.toArray(new Integer[list.size()]));
    }
}
