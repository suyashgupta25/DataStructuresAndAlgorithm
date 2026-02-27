package com.practice.dsa;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class FoodDeliveryService {

    public static void main(String[] args) {
        // v = u+1; v=u-1
        // v= u * 2; v = u/2
        // sort the digits in descending order
        // 1 -> 2 -> 4 -> 8 -> 16 -> 61
        System.out.println(solve(100, 61));
    }

    public static int solve(int n, int x) {
        int evaluate = evaluate(x, 1, n);

        return evaluate;
    }

    public static int evaluate(int x, int num, int n) {
        if (num == x) {
            return 0;
        }
        int shouldDouble = shouldDouble(n, num);
        int shouldReverse = shouldReverse(n, num);

        if (shouldDouble != -1) {
            return 1 + evaluate(x, shouldDouble, n);
        }

        if (shouldReverse != -1) {
            return 1 + evaluate(x, shouldReverse, n);
        }

        return  1 + shouldAddOrSub(n, num, x);
    }

    private static int shouldDouble(int n, int num) {
        int doubleNum = num * 2;
        if (doubleNum < n) {
            return doubleNum;
        } else {
            return -1;
        }
    }

    private static int shouldReverse(int n, int num) {
        String stringNum = String.valueOf(num);
        if(stringNum.length() < 2) {
            return -1;
        }
        Stream<String> stringStream = Arrays.stream(stringNum.split(""))
                .map(Integer::valueOf)
                .sorted(Collections.reverseOrder())
                .map(String::valueOf);
        String string = stringStream.collect(Collectors.joining());
        int reversed = Integer.parseInt(string);
        if (reversed < n && reversed > num) {
            return reversed;
        } else {
            return -1;
        }
    }

    private static int shouldAddOrSub(int n, int num, int x) {
        if(num > x) {
            return num - 1;
        } else {
            return num + 1;
        }
    }
}