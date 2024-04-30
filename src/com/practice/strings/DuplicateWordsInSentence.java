package com.practice.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DuplicateWordsInSentence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        List<String> sentences = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String string = scanner.nextLine();
            sentences.add(string);
        }
        for (String sentence : sentences) {
            List<String> finalSentence = new ArrayList<>();
            String[] words = sentence.split(" ");
            for (String word: words) {
                if(finalSentence.stream().noneMatch(it -> it.equalsIgnoreCase(word))) {
                    finalSentence.add(word);
                }
            }
            for (String flag: finalSentence) {
                System.out.printf(flag+ " ");
            }
            System.out.println();
        }
    }
}