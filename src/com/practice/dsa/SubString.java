package com.practice.dsa;

public class SubString {

    public static void main(String[] args) {
//        int i = sameString("uaccd", "gbbeg", 4);
        int i = sameString("ikgpda", "ikxmdc", 6);
//        int i = sameString("adpgki", "cdmxki", 6);
        System.out.println(i);
    }

    public static int sameString(String s, String t, int K) {
        int min = 0;
        for (int j = 0; j < s.length(); j++) {
            int cost = K;
            for (int i = j; i < s.length(); i++) {
                char charAtS = s.charAt(i);
                char charAtT = t.charAt(i);
                int abs = Math.abs((int) charAtS - (int) charAtT);
                cost = cost - abs;
                if(cost < 0) {
                    int offset =  Math.abs(i-j);
                    if(offset > min) {
                        min = offset;
                    }
                    break;
                }
            }
        }

        return min;
    }
}
