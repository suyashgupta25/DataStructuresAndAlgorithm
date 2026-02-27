package com.practice.dsa;

import java.util.*;

public class FD {

    // Helper function to sort the digits of a number in descending order
    public static int sortDigitsDesc(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        Arrays.sort(digits);
        StringBuilder sb = new StringBuilder(new String(digits));
        return Integer.parseInt(sb.reverse().toString());
    }

    // BFS function to find minimum operations
    public static int minOperations(int n, int target) {
        if (target == 1) return 0;

        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(new int[]{1, 0});
        visited.add(1);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int house = current[0];
            int steps = current[1];

            int[] nextHouses = {house + 1, house - 1, house * 2, house / 2, sortDigitsDesc(house)};
            for (int nextHouse : nextHouses) {
                if (nextHouse == target) {
                    return steps + 1;
                }
                if (nextHouse > 0 && nextHouse <= n && !visited.contains(nextHouse)) {
                    visited.add(nextHouse);
                    queue.add(new int[]{nextHouse, steps + 1});
                }
            }
        }
        return -1;
    }

    // Main method to handle input and output
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int target = scanner.nextInt();
            System.out.println(minOperations(n, target));
        }
        scanner.close();
    }
}

