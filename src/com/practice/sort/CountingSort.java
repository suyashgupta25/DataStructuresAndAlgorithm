package com.practice.sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CountingSort {

    public static void main(String[] args) throws IOException {
        File file = new File("file_inputs/count_sort_large_data.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<List<String>> arr = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        countSort(arr);
        bufferedReader.close();
    }

    public static void main2(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(0);
        countingSort(list);
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        int[] array = new int[100];
        for (int i = 0; i < arr.size(); i++) {
            Integer value = arr.get(i);
            array[value] += 1;
        }
        List<Integer> sorted = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int count = array[i];
            for (int j = 0; j < count; j++) {
                sorted.add(i);
            }
        }
//        printArray(array);
        return sorted;
    }

    public static void countSort(List<List<String>> arr) {
        long start = System.currentTimeMillis();
        String[] listArray = new String[100];
        int size = arr.size();
        int i1 = size / 2;
        for (int i = 0; i < size; i++) {
            List<String> strings = arr.get(i);
            String first = strings.get(0);
            int s0 =  Integer.parseInt(first);
            String s1 = i < i1 ? "-" : strings.get(1);
            listArray[s0] = (listArray[s0] == null) ? s1 : (listArray[s0] + " " + s1);
        }
        Arrays.stream(listArray).forEach(f -> {
            if(f != null) {
                System.out.printf(f+" ");
            }
        });
        System.out.println();
        System.out.printf("Time in milli>>"+(System.currentTimeMillis() - start));
    }

    static void printArray(int[] updatesMatrix) {
        for (int i = 0; i < updatesMatrix.length; i++) {
            System.out.printf("%d", updatesMatrix[i]);
            System.out.printf(" ");
        }
    }
}
