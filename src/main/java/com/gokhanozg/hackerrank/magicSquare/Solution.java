package com.gokhanozg.hackerrank.magicSquare;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {


    private static final Scanner scanner = new Scanner(System.in);
    static List<int[][]> mmList = new ArrayList<>();

    static {
        mmList.add(new int[][]{{4, 3, 8}, {9, 5, 1}, {2, 7, 6}});
        mmList.add(new int[][]{{6, 7, 2}, {1, 5, 9}, {8, 3, 4}});
        mmList.add(new int[][]{{6, 1, 8}, {7, 5, 3}, {2, 9, 4}});
        mmList.add(new int[][]{{8, 1, 6}, {3, 5, 7}, {4, 9, 2}});
        mmList.add(new int[][]{{8, 3, 4}, {1, 5, 9}, {6, 7, 2}});
        mmList.add(new int[][]{{2, 9, 4}, {7, 5, 3}, {6, 1, 8}});
        mmList.add(new int[][]{{4, 9, 2}, {3, 5, 7}, {8, 1, 6}});
        mmList.add(new int[][]{{2, 7, 6}, {9, 5, 1}, {4, 3, 8}});
    }

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        int minCost = Integer.MAX_VALUE;
        for (int[][] ints : mmList) {
            int cost = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    cost += Math.abs(s[i][j] - ints[i][j]);
                }
            }
            minCost = Math.min(minCost, cost);
        }
        return minCost;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
