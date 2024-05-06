package com.practice.java;

import java.util.Scanner;
import java.util.function.Function;

public class LambdaExpressions {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < count; i++) {
            String valuesStr = scanner.nextLine();
            String[] strings = valuesStr.split(" ");
            int num = Integer.parseInt(strings[1]);
            if(strings[0].equals("2")) {
                if(isPrime().apply(num)) {
                    System.out.println("PRIME");
                } else {
                    System.out.println("COMPOSITE");
                }
            } else if(strings[0].equals("1")) {
                if(isOdd().apply(num)) {
                    System.out.println("ODD");
                } else {
                    System.out.println("EVEN");
                }
            } else {
                if(isPalindrome().apply(num)) {
                    System.out.println("PALINDROME");
                } else {
                    System.out.println("NOT PALINDROME");
                }
            }
        }
    }

    static Function<Integer, Boolean> isOdd() {
        return (it) -> it % 2 != 0;
    }

    static Function<Integer, Boolean> isPrime() {
        return (it) -> checkPrime(it);
    }

    static Function<Integer, Boolean> isPalindrome() {
        return (it) -> {
            String string = it.toString();
            StringBuilder builder = new StringBuilder(it.toString());
            String reverse = builder.reverse().toString();
            return reverse.contentEquals(string);
        };
    }

    static boolean checkPrime(int num) {
        return checkPrime(num, --num);
    }
    static boolean checkPrime(int num, int k) {
        if(k==1) {
            return true;
        }

        int half = (num / 2);
        if(num % k == 0) {
            return false;
        } else if (k < half) {
            return true;
        } else {
            return checkPrime(num, --k);
        }
    }
}
