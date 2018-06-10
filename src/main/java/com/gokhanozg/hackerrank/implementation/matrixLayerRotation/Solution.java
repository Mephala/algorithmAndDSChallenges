package com.gokhanozg.hackerrank.implementation.matrixLayerRotation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);
    private static Map<Integer, Integer> rectangleResetRotationMap = new HashMap<Integer, Integer>();

    // Complete the matrixRotation function below.
    static void matrixRotation(int[][] matrix, int r) {
        final int n = matrix[0].length;
        final int m = matrix.length;
        int resetRotation = findResetRotation(m, n);
        int minmn = Math.min(m, n);
        int rectangleCount = minmn / 2;
        for (int i = 0; i < rectangleCount; i++) {
            rectangleResetRotationMap.put(i, findResetRotation(m - (i * 2), n - (i * 2)));
        }
        rotateMatrix(matrix, r);
        printMatrix(matrix);
    }

    private static int findResetRotation(int m, int n) {
        return 1 + (m - 1) + (n - 1) + (n - 1) + (m - 2);
    }

    private static void rotateMatrix(int[][] matrix, int r) {
        final int n = matrix[0].length;
        final int m = matrix.length;
        int minmn = Math.min(m, n);
        int rectangleCount = minmn / 2;
        for (int i = 0; i < rectangleCount; i++) {
            int rotateCount = r % rectangleResetRotationMap.get(i);
            for (int p = 0; p < rotateCount; p++) {
                int leftmost = matrix[i][i];
                for (int j = i; j < n - i; j++) {
                    if (!((j + 1) == (n - i))) {
                        matrix[i][j] = matrix[i][j + 1];
                    }
                }
                for (int j = i; j < m - i; j++) {
                    if (!((j + 1) == (m - i))) {
                        matrix[j][n - 1 - i] = matrix[j + 1][n - 1 - i];
                    }
                }
                for (int j = n - 1 - i; j > i; j--) {
                    if (!(j - 1 == i - 1)) {
                        matrix[m - 1 - i][j] = matrix[m - 1 - i][j - 1];
                    }
                }
                for (int j = m - 1 - i; j > i; j--) {
                    if (!(j - 1 == i)) {
                        matrix[j][i] = matrix[j - 1][i];
                    }
                }
                matrix[i + 1][i] = leftmost;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        String retval = stringifyMatrix(matrix);
        System.out.println(retval);
    }

    private static String stringifyMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sb.append(matrix[i][j]);
                if (j == matrix[0].length - 1) {
                    sb.append(System.getProperty("line.separator"));
                } else {
                    sb.append(" ");
                }

            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String[] mnr = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mnr[0]);
        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            String[] matrixRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < n; j++) {
                int matrixItem = Integer.parseInt(matrixRowItems[j]);
                matrix[i][j] = matrixItem;
            }
        }

        matrixRotation(matrix, r);

        scanner.close();
    }
}
