package com.practice.strings;

import java.util.ArrayList;
import java.util.List;

public class VehicleNumberCodeGeneration {


    public static void main(String[] args) {
        List<String> codes = new ArrayList<>();
        codes.add("ab");
        codes.add("123");
        codes.add("@-");
        generateCodes2(codes, 400);
    }

    static void generateCodes2(List<String> strings, int count) {
        List<CodeObj> list = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            CodeObj codeObj = new CodeObj(strings.get(i), i + 1);
            list.add(codeObj);
        }
        int[] pointers = new int[list.size()];
        while (count > 0) {
            printCode(list, pointers);
            for (int i = pointers.length - 1; i >= 0; i--) {
                int pointerAtI = pointers[i];
                CodeObj codeObj = list.get(i);
                int lengthOfString = codeObj.code.length();
                if (pointerAtI < lengthOfString - 1) {
                    pointers[i]++;
                    break;
                } else {
                    pointers[i] = 0;
                    codeObj.repeatCount = codeObj.repeatCount - 1;
                }
            }
            boolean isAllZero = true;
            for (int i = 0; i < list.size(); i++) {
                CodeObj codeObj = list.get(i);
                if(codeObj.repeatCount > 0) {
                    isAllZero = false;
                }
            }
            if (isAllZero) {
                break;
            }
            count--;
        }
    }

    private static void printCode(List<CodeObj> list, int[] pointers) {
        String code = "";
        for (int i = 0; i < list.size(); i++) {
            String string = list.get(i).code;
            char charAt = string.charAt(pointers[i]);
            code = code + charAt;
        }
        System.out.print(code + " ");
    }

    static void generateCodes(List<String> list, int count) {
        int[] pointers = new int[list.size()];
        while (count > 0) {
            String code = "";
            for (int i = 0; i < list.size(); i++) {
                String string = list.get(i);
                char charAt = string.charAt(pointers[i]);
                code = code + charAt;
            }
            System.out.print(code + " ");
            for (int i = pointers.length - 1; i >= 0; i--) {
                int pointerAtI = pointers[i];
                int lengthOfString = list.get(i).length();
                if (pointerAtI < lengthOfString - 1) {
                    pointers[i]++;
                    break;
                } else {
                    pointers[i] = 0;
                }
            }
            if (pointers[0] == list.get(0).length() - 1) {
                break;
            }
            count--;
        }
    }

    static class CodeObj {
        private final String code;
        private int repeatCount;

        public CodeObj(String code, int repeatCount) {
            this.code = code;
            this.repeatCount = repeatCount;
        }

        public void setRepeatCount(int repeatCount) {
            this.repeatCount = repeatCount;
        }
    }

}
