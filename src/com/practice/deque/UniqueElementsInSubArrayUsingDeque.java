package com.practice.deque;

import java.util.*;

public class UniqueElementsInSubArrayUsingDeque {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> uniqueElements = new HashSet<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            uniqueElements.add(num);

            if(deque.size() == m+1) {
                Integer remove = deque.remove();
                if(!deque.contains(remove)) {
                    uniqueElements.remove(remove);
                }
            }
            max = Math.max(max, uniqueElements.size());
        }
        System.out.println(max);
    }
}























