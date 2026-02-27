package com.practice.strings;

public class PermutationsOfString {

    // Function to print all the permutations of str
    static void printPermutation(String str, String ans) {

        // If string is empty
        if (str.isEmpty()) {
            System.out.print(ans + " ");
            return;
        }
        for (int i = 0; i < str.length(); i++) {

            // ith character of string
            char ch = str.charAt(i);

            // Rest of the string after excluding the ith character
            String remainingStr = str.substring(0, i) + str.substring(i + 1);

            // Recursive call
            printPermutation(remainingStr, ans + ch);
        }
    }

    // Driver code
    public
    static void main(String[] args) {
        String s = "abcd";
        printPermutation(s, "");
    }
}
