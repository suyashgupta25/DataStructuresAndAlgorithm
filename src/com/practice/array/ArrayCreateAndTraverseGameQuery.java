package com.practice.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayCreateAndTraverseGameQuery {

    private static boolean canWin(int leap, int[] game, int i) {
        if (i < 0 || game[i] == 1) {
            return false;
        }
        if (i + 1 >= game.length || i + leap >= game.length) {
            return true;
        }
        game[i] = 1;

        return canWin(leap, game, i + leap) ||
                canWin(leap, game, i + 1) ||
                canWin(leap, game, i - 1);
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game, 0)) ? "YES" : "NO" );
        }
        scan.close();
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        int[][] array = new int[count][];
        int[][] query = new int[count][];
        for (int i = 0; i < count; i++) {
            String leapQueryStr = scanner.nextLine();
            String[] strings = leapQueryStr.split(" ");
            int localSize = Integer.parseInt(strings[0]);
            int[] local = new int[localSize];
            String arrayStr = scanner.nextLine();
            String[] arrayValues = arrayStr.split(" ");
            for (int j = 0; j < localSize; j++) {
                local[j] = Integer.parseInt(arrayValues[j]);
            }
            array[i] = local;
            int[] localQ = new int[2];
            localQ[0] = localSize;
            localQ[1] = Integer.parseInt(strings[1]);
            query[i] = localQ;
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int[] arrayByIndex = array[i];
            int leap = query[i][1];
            boolean flag = true;
            int localPointer = 0;
            while (localPointer < arrayByIndex.length) {
                if (localPointer + 1 >= arrayByIndex.length) {
                    break;
                }
                if (arrayByIndex[localPointer+1] == 1) {
                    int newPointer = localPointer + leap;
                    if (newPointer >= arrayByIndex.length) {
                        break;
                    } else  {
                        if (arrayByIndex[newPointer] == 1) {
                            if(arrayByIndex[newPointer-1] == 0 && leap != 1) {
                                localPointer = newPointer - 1;
                            } else {
                                res.add("NO");
                                flag = false;
                                break;
                            }
                        } else {
                            localPointer = newPointer;
                        }
                    }
                }
                localPointer++;
            }
            if (flag) {
                res.add("YES");
            }
        }

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }


}
