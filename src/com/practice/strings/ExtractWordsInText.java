package com.practice.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExtractWordsInText {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "           YES      leading spaces        are valid,    problemsetters are         evillllllA";//scanner.nextLine();

        List<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for(int i = 0; i < text.length(); i++) {
            char charAt = text.charAt(i);
            if(word.isEmpty()) {
                if((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                    word.append(charAt);
                } else {
                }
            } else {
                if((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                    word.append(charAt);
                    if(i == text.length() -1) {
                        words.add(word.toString());
                    }
                } else {
                    words.add(word.toString());
                    word = new StringBuilder();
                }
            }
        }
        System.out.println(words.size());
        for (String wordValue: words) {
            System.out.println(wordValue);
        }
    }
}
