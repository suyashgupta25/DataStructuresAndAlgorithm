package com.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TwoDArrayRotate {

    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        int num = 6;
        int col = 4;
        for (int i = 0; i < num; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                list.add(i * num + j + 1);
            }
            matrix.add(list);
        }
        print(matrix);
        System.out.println("-------------------------------------------");
        matrixRotation(matrix, 1);
    }

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        List<List<Integer>> matrixLocal = new ArrayList<>(matrix);
        int n = matrixLocal.size();// rows
        int m = matrixLocal.get(0).size();// columns
//        updatesMatrix = new Integer[n][m];
        for (int i = 0; i < r; i++) {
            updatesMatrix = matrixLocal.stream().map(u -> u.toArray(new Integer[0])).toArray(Integer[][]::new);
            top(matrixLocal);
            bottom(matrixLocal);
            left(matrixLocal, n);
            right(matrixLocal, n);
            matrixLocal = Arrays.stream(updatesMatrix)
                    .map(Arrays::asList)
                    .collect(Collectors.toList());
        }
//        print(matrixLocal);
        printArray();
    }

    private static Integer[][] updatesMatrix;

    static void top(List<List<Integer>> matrix) {
        for (int i = 0; i < matrix.size() / 2; i++) {
            List<Integer> integers = matrix.get(i);
            for (int j = i; j < integers.size() - i - 1; j++) {
                updatesMatrix[i][j] = integers.get(j + 1);
            }
        }
    }

    static void bottom(List<List<Integer>> matrix) {
        for (int i = matrix.size() - 1; i >= matrix.size() / 2; i--) {
            List<Integer> integers = matrix.get(i);
            for (int j = 0; j < integers.size() - 1; j++) {
                updatesMatrix[i][j + 1] = integers.get(j);
            }
        }
    }

    static void left(List<List<Integer>> matrix, int n) {
        for (int i = 0; i < matrix.size() / 2; i++) {
            List<Integer> fromTopRow = matrix.get(i);
            for (int j = 0; j < i + 1; j++) {
                updatesMatrix[i + 1][j] = fromTopRow.get(j);
            }
            List<Integer> fromBottomRow = matrix.get(n - i - 2);
            for (int j = 0; j < i + 1; j++) {
                updatesMatrix[n - i - 1][j] = fromBottomRow.get(j);
            }
        }
    }

    static void right(List<List<Integer>> matrix, int n) {
        for (int i = 0; i < matrix.size() / 2; i++) {
            List<Integer> fromTopRow = matrix.get(i + 1);
            int sizeM = fromTopRow.size();
            for (int j = sizeM - 1; j > sizeM - i - 2; j--) {
                updatesMatrix[i][j] = fromTopRow.get(j);
            }
            List<Integer> fromBottomRow = matrix.get(n - i - 1);
            for (int j = sizeM - 1; j > sizeM - i - 2; j--) {
                updatesMatrix[n - i - 2][j] = fromBottomRow.get(j);
            }
        }
    }

    static void print(List<List<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            List<Integer> integers = matrix.get(i);
            for (int j = 0; j < integers.size(); j++) {
                System.out.printf("%02d", integers.get(j));
                System.out.printf(" ");
            }
            System.out.println();
        }
    }

    static void printArray() {
        for (int i = 0; i < updatesMatrix.length; i++) {
            Integer[] integers = updatesMatrix[i];
            for (int j = 0; j < integers.length; j++) {
                System.out.printf("%02d", integers[j]);
                System.out.printf(" ");
            }
            System.out.println();
        }
    }
}
