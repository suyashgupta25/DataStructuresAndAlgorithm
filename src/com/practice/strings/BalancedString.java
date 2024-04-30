package com.practice.strings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BalancedString {

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
            String string = nums.get(i);
            List<Character> list = new ArrayList<>();
            for (int j = 0; j < string.length(); j++) {
                char charAt = string.charAt(j);
                if(charAt == '{') {
                    list.add(charAt);
                } else if (charAt == '(') {
                    list.add(charAt);
                } else if (charAt == '}') {
                    if(!list.isEmpty() && list.get(list.size() - 1) == '{') {
                        list.remove(list.size() - 1);
                    } else {
                        System.out.println("false");
                        break;
                    }
                } else if (charAt == ')') {
                    if(!list.isEmpty() && list.get(list.size() - 1) == '(') {
                        list.remove(list.size() - 1);
                    } else {
                        System.out.println("false");
                        break;
                    }
                }
                if(j == string.length() -1 && list.isEmpty()) {
                    System.out.println("true");
                }
            }
        }
    }

}
