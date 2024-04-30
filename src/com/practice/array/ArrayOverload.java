package com.practice.array;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayOverload {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] strings = string.split(" ");
        Arithmetic arithmetic = new Arithmetic();

        try {
            Integer.parseInt(strings[0]);
            int[] result = Arrays.stream(strings).mapToInt(s -> {
                try {
                    return Integer.parseInt(s);
                } catch (NumberFormatException ex) {
                    return Integer.MIN_VALUE;
                }
            }).toArray();
            System.out.println(arithmetic.sum(result));
        } catch (Exception e) {
            System.out.println(arithmetic.sum(strings));
        }

    }

    private static class Arithmetic {

        String sum(String[] array) {
            String sum = "";
            for (int i = 0; i < array.length; i++) {
                sum = sum + array[i];
            }
            return sum;
        }

        Integer sum(int[] integers) {
            int sum = 0;
            for (int i = 0; i < integers.length; i++) {
                sum = sum + integers[i];
            }
            return sum;
        }
    }
}
