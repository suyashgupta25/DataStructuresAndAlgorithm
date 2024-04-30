package com.practice.strings;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class PatternSyntaxChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        String[] patterns = new String[count];
        for(int i=0; i<count; i++) {
            String pattern = scanner.nextLine();
            patterns[i] = pattern;
        }

        for(String pattern: patterns) {
            try {
                Pattern.compile(pattern);
                System.out.println("Valid");
            }  catch (PatternSyntaxException exception) {
                System.out.println("Invalid");
            }
        }
    }
}
