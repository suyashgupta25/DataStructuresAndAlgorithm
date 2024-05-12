package com.practice.java;

import java.math.BigInteger;

public class LongFactorial {

    public static void main(String[] args) {
        System.out.println(extraLongFactorials(100));
    }

    public static BigInteger extraLongFactorials(long n) {
        if (n == 1) {
            return BigInteger.valueOf(1);
        }

        return BigInteger.valueOf(n).multiply(extraLongFactorials(n - 1));
    }
}
