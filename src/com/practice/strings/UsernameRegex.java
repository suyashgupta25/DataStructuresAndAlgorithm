package com.practice.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsernameRegex {

    public static final String regularExpression = "^[a-zA-Z0-9]+([_]?[a-zA-Z0-9]+)*$";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        List<String> usernames = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String string = scanner.nextLine();
            usernames.add(string);
        }
        Pattern pattern = Pattern.compile(regularExpression);
        for (String username : usernames) {
            if(username.length()<8 || username.length()>30) {
                System.out.println("Invalid");
            } else {
                Matcher matcher = pattern.matcher(username);
                boolean matchFound = matcher.find();
                if(matchFound) {
                    System.out.println("Valid");
                } else {
                    System.out.println("Invalid");
                }
            }
        }
    }
}