package com.practice.strings;

import java.util.Scanner;

public class LexogrphicalSubStringFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int k = scanner.nextInt();
        String smallest = "";
        String largest = "";
        for (int i = 0; i <= text.length() - k; i++) {
            String sub = text.substring(i, i + k);
            if (i == 0) {
                smallest = largest = sub;
            } else {
                if (smallest.compareTo(sub) > 0) {
                    smallest = sub;
                }
                if (largest.compareTo(sub) < 0) {
                    largest = sub;
                }
            }
        }
        System.out.println(smallest);
        System.out.println(largest);
    }
}
