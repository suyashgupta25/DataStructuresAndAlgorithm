package com.practice.array;

import java.util.Arrays;
import java.util.Scanner;

public class SubArrayNegativeSumCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        String numStr = scanner.nextLine();
        String[] strings = numStr.split(" ");
        int[] array = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();

//        int[] array = {1, -2, 4, -5, 1};
        int negatives = 0;
        for (int i = 1; i <= array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (j + i <= array.length) {
                    int sum = 0;
                    for (int k = j; k < j + i; k++) {
                        sum = sum + array[k];
                    }
                    if (sum < 0) {
//                        System.out.println("i=" + i + " j=" + j);
                        ++negatives;
                    }
                }
            }
        }
        System.out.println(negatives);
    }
}
