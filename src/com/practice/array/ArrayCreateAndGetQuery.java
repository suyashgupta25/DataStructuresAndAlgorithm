package com.practice.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayCreateAndGetQuery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        int[][] array = new int[count][];
        for (int i = 0; i < count; i++) {
            String numStr = scanner.nextLine();
            String[] strings = numStr.split(" ");
            int localSize = Integer.parseInt(strings[0]);
            int[] local = new int[localSize];
            for (int j = 0; j < localSize; j++) {
                local[j] = Integer.parseInt(strings[j+1]);
            }
            array[i] = local;
        }
        int queryCount = Integer.parseInt(scanner.nextLine());
        List<String> res = new ArrayList<>();
        for (int i = 0; i < queryCount; i++) {
            String numStr = scanner.nextLine();
            String[] strings = numStr.split(" ");
            int x = Integer.parseInt(strings[0]);
            int y = Integer.parseInt(strings[1]);
            try {
                res.add(String.valueOf(array[x-1][y-1]));
            } catch (IndexOutOfBoundsException e) {
                res.add("ERROR!");
            }
        }

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
