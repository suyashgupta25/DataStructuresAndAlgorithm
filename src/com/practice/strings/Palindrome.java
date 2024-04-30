package com.practice.strings;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String isPalindrome = "Yes";

        for (int i = 0; i < text.length() / 2; i++) {
            if (text.charAt(i) != text.charAt(text.length() - 1 - i)) {
                isPalindrome = "No";
                break;
            }
        }
        System.out.println(isPalindrome);
    }
}
