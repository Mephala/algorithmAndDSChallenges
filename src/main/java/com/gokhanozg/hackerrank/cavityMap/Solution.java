package com.gokhanozg.hackerrank.cavityMap;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the cavityMap function below.
    static String[] cavityMap(String[] grid) {
        if (grid.length < 3) {
            return grid;
        }
        int[][] matrix = new int[grid.length][grid[0].length()];
        for (int i = 0; i < matrix.length; i++) {
            String line = grid[i];
            for (int j = 0; j < line.length(); j++) {
                matrix[i][j] = Integer.parseInt(Character.toString(line.charAt(j)));
            }
        }
        Set<String> cavities = new HashSet<>();
        for (int i = 1; i < matrix.length - 1; i++) {
            for (int j = 1; j < matrix[0].length - 1; j++) {
                int cell = matrix[i][j];
                int top = matrix[i - 1][j]; //top
                int bottom = matrix[i + 1][j]; //bottom
                int left = matrix[i][j - 1]; //left
                int right = matrix[i][j + 1]; // right
                if (cell > top && cell > bottom && cell > left && cell > right) {
                    cavities.add("" + i + "_" + j);
                }
            }
        }
        String[] r = new String[grid.length];
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < matrix[0].length; j++) {
                if (cavities.contains("" + i + "_" + j)) {
                    sb.append("X");
                } else {
                    sb.append(matrix[i][j]);
                }
            }
            r[i] = sb.toString();
        }
        return r;

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = cavityMap(grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
