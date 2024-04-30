package com.practice.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IPAddressValidator {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        List<String> ips = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            String ip = scanner.nextLine();
            ips.add(ip);
        }
        for (String text : ips) {
            String[] strings = text.split("\\.");
            if (strings.length != 4) {
                System.out.println(false);
            } else {
                boolean flag = true;
                for (String string : strings) {
                    try {
                        if (string.length() > 3) {
                            flag = false;
                        } else {
                            int num = Integer.parseInt(string);
                            if (num < 0 || num > 255) {
                                flag = false;
                            }
                        }
                    } catch (NumberFormatException e) {
                        flag = false;
                    }
                }
                System.out.println(flag);
            }
        }
    }
}