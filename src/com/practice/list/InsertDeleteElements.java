package com.practice.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertDeleteElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(scanner.nextInt());
        }
        int queries = scanner.nextInt();
        scanner.nextLine();
        while (queries-- > 0) {
            String query = scanner.nextLine();
            String valuesStr = scanner.nextLine();
            if(query.equals("Insert")) {
                String[] strings = valuesStr.split(" ");
                int[] values = new int[2];
                values[0] = Integer.parseInt(strings[0]);
                values[1] = Integer.parseInt(strings[1]);
                list.add(values[0], values[1]);
            } else {
                int[] values = new int[1];
                values[0] = Integer.parseInt(valuesStr);
                list.remove(values[0]);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.printf(list.get(i)+" ");
        }
    }

}
