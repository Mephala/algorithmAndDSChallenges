package com.gokhanozg.hackerrank.algorithms.warmup.diagonalDifferenceProblem;

import java.io.*;
import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the diagonalDifference function below.
    static int diagonalDifference(int[][] a) {
        int diagonal1 = 0;
        int diagonal2 = 0;
        int matrixSize = a[0].length;
        for (int i = 0; i < matrixSize; i++) {
            diagonal1 += a[i][i];
            diagonal2 += a[i][matrixSize - 1 - i];
        }
        return Math.abs((diagonal1 - diagonal2));
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] a = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] aRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < n; j++) {
                int aItem = Integer.parseInt(aRowItems[j]);
                a[i][j] = aItem;
            }
        }

        int result = diagonalDifference(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
