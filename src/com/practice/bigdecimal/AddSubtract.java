package com.practice.bigdecimal;

import java.math.BigInteger;
import java.util.Scanner;

public class AddSubtract {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numStr = scanner.nextLine();
        BigInteger num = new BigInteger(numStr);
        String numStr2 = scanner.nextLine();
        BigInteger num2 = new BigInteger(numStr2);
        System.out.println(num.add(num2));
        System.out.println(num.multiply(num2));
    }
}
