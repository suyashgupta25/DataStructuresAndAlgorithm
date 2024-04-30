package com.practice.array;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayPrintJ {

    public static void main(String[] args)  throws IOException {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        List<String> nums = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String ip = scanner.nextLine();
            nums.add(ip);
        }

        for (int i = 0; i < nums.size(); i++) {
            System.out.println(nums.get(i));
        }
    }

}
