package com.practice.ibm;

import java.util.Stack;

public class ReduceTheString {

    public static String reducedString(int k, String s) {
        if (k == 1) {
            return "";
        }

        Stack<Data> stack = new Stack<Data>();

        int length = s.length();

        for (int i = 0; i < length; i++) {
            if (stack.isEmpty()) {
                stack.push(new Data(s.charAt(i), 1));
                continue;
            }

            if (stack.peek().c == s.charAt(i)) {
                Data p = stack.peek();
                stack.pop();
                p.ctr += 1;
                if (p.ctr == k) {
                    continue;
                } else {
                    stack.push(p);
                }
            } else {
                stack.push(new Data(s.charAt(i), 1));
            }
        }

        StringBuilder output = new StringBuilder();

        while (!stack.isEmpty()) {
            char c = stack.peek().c;
            int cnt = stack.peek().ctr;
            while (cnt-- > 0)
                output.append(c);
            stack.pop();
        }
        output.reverse();
        return output.toString();
    }

    public static void main(String[] args) {
        int k = 2;
        String st = "geeksforgeeks";
        String ans = reducedString(k, st);
        System.out.println(ans);
    }

    static class Data {
        char c;
        int ctr;

        Data(char c, int ctr) {
            this.c = c;
            this.ctr = ctr;
        }
    }
}
