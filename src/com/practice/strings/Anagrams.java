package com.practice.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagrams {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String aText = scanner.nextLine().toLowerCase();
        String bText = scanner.nextLine().toLowerCase();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < aText.length(); i++) {
            Character charAt = aText.charAt(i);
            if(map.containsKey(charAt)) {
                map.put(charAt, map.get(charAt) + 1);
            } else {
                map.put(charAt, 1);
            }
        }

        for (int i = 0; i < bText.length(); i++) {
            Character charAt = bText.charAt(i);
            if(map.containsKey(charAt)) {
                if(map.get(charAt) == 1) {
                    map.remove(charAt);
                } else {
                    map.put(charAt, map.get(charAt) - 1);
                }
            } else {
                map.put(charAt, 1);
            }
        }
        if(map.isEmpty()) {
            System.out.println("Anagrams");
        } else {
            System.out.println("Not Anagrams");
        }
    }
}
