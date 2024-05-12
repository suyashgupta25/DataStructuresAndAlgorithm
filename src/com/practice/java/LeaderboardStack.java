package com.practice.java;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LeaderboardStack {

    public static void main(String[] args) throws IOException {
        File file = new File("file_inputs/demo_input.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        List<Integer> result = climbingLeaderboard(ranked, player);
        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );
        bufferedReader.close();
        bufferedWriter.close();
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        if (ranked.size() == 1) {
            return new ArrayList<>(player);
        }

        int c = 1;
        List<List<Integer>> rs = new ArrayList<>(List.of(List.of(ranked.get(0), c)));

        for (int i = 1; i <= ranked.size() - 1; i++) {
            if (Objects.equals(ranked.get(i), ranked.get(i - 1))) {
                rs.add(List.of(ranked.get(i), rs.get(i - 1).get(1)));
            } else {
                c++;
                rs.add(List.of(ranked.get(i), c));
            }
        }

        int rsi = rs.size() - 1;
        int psi = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= rsi; rsi--) {
            if (player.get(psi) < ranked.get(rsi)) {
                while (rsi < rs.size() - 1 && player.get(psi) < ranked.get(rsi + 1)) {
                    rsi++;
                }
                result.add(rs.get(rsi).get(1) + 1);
                psi++;
            } else if (player.get(psi) == ranked.get(rsi) || rsi == 0) {
                result.add(rs.get(rsi).get(1));
                psi++;
            }

            if (rsi == 0 && psi <= player.size() - 1) {
                rsi++;
            }

            if (result.size() == player.size()) {
                break;
            }
        }
        return result;
    }

    public static List<Integer> climbingLeaderboard3(List<Integer> ranked, List<Integer> player) {
        Stack<Integer> stack = new Stack<>();
        stack.push(ranked.get(0));
        for (Integer integer : ranked) {
            if (!Objects.equals(stack.peek(), integer)) {
                stack.push(integer);
            }
        }
        List<Integer> ranks = new ArrayList<>();
        for (int i = 0; i < player.size(); i++) {
            Integer integer = player.get(i);
            List<Integer> second = new ArrayList<>();
            int size = stack.size();
            for (int j = 0; j < size; j++) {
                if (Objects.equals(stack.peek(), integer)) {
                    ranks.add(stack.size());
                    stack.addAll(second);
                    break;
                } else if (stack.peek() > integer) {
                    ranks.add(stack.size() + 1);
                    stack.push(integer);
                    stack.addAll(second);
                    break;
                } else {
                    Integer pop = stack.pop();
                    second.add(pop);
                }
                if (j == size - 1) {
                    ranks.add(stack.size() + 1);
                    stack.push(integer);
                    stack.addAll(second);
                }
            }
        }
        return ranks;
    }

    public static List<Integer> climbingLeaderboard2(List<Integer> ranked, List<Integer> player) {
        List<Integer> list = new ArrayList<>();
        List<Integer> sortedDescending = ranked.stream().distinct().collect(toList());
        for (Integer playerScore : player) {
            int index = 0;
            boolean isAdded = false;
            for (Integer oldValue : sortedDescending) {
                if (Objects.equals(oldValue, playerScore)) {
                    list.add(index + 1);
                    isAdded = true;
                    break;
                } else if (oldValue < playerScore) {
                    sortedDescending.add(index, playerScore);
                    list.add(index + 1);
                    isAdded = true;
                    break;
                }
                index++;
            }
            if (!isAdded) {
                sortedDescending.add(playerScore);
                list.add(sortedDescending.size());
            }
        }
        return list;
    }
}
