package com.gokhanozg.hackerrank.bombermanGame;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the bomberMan function below.


    private static final Scanner scanner = new Scanner(System.in);

    static String[] bomberMan(int n, String[] grid) {
        int[][] bombMatrix = new int[grid.length][grid[0].length()];
        int[][] fullMatrix = new int[grid.length][grid[0].length()];
        for (int i = 0; i < bombMatrix.length; i++) {
            for (int j = 0; j < bombMatrix[0].length; j++) {
                bombMatrix[i][j] = grid[i].charAt(j) == '.' ? 0 : 1; // 1 for bomb, 0 for no bomb.
                fullMatrix[i][j] = 1;
            }
        }
        if (n == 1) {
            return stringifyMatrix(bombMatrix);
        } else if (n == 2) {
            return stringifyMatrix(fullMatrix); // filled with bombs.
        } else {
            bombMatrix = detonate(bombMatrix);
            int[][] det = bombMatrix;
            int[][] init = detonate(bombMatrix);
            n -= 3;
            if (n % 2 == 1) {
                return stringifyMatrix(fullMatrix);
            } else if (n % 4 == 2) {
                return stringifyMatrix(init);
            } else {
                return stringifyMatrix(det);
            }
        }
    }

    private static int[][] detonate(int[][] bombMatrix) {
        int[][] ret = new int[bombMatrix.length][bombMatrix[0].length];
        for (int i = 0; i < bombMatrix.length; i++) {
            for (int j = 0; j < bombMatrix[0].length; j++) {
                int right = j + 1 < bombMatrix[0].length && bombMatrix[i][j + 1] == 1 ? 1 : 0;
                int left = j - 1 >= 0 && bombMatrix[i][j - 1] == 1 ? 1 : 0;
                int top = i - 1 >= 0 && bombMatrix[i - 1][j] == 1 ? 1 : 0;
                int bottom = i + 1 < bombMatrix.length && bombMatrix[i + 1][j] == 1 ? 1 : 0;
                int centre = bombMatrix[i][j];
                ret[i][j] = right == 1 || left == 1 || top == 1 || bottom == 1 || centre == 1 ? 0 : 1; // if has bomb nearby, detonates and equals zero. Otherwise has bomb.
            }
        }
        return ret;
    }

    private static String[] stringifyMatrix(int[][] bombMatrix) {

        String[] ret = new String[bombMatrix.length];
        for (int i = 0; i < ret.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < bombMatrix[0].length; j++) {
                sb.append(bombMatrix[i][j] == 1 ? "O" : ".");
            }
            ret[i] = sb.toString();
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] rcn = scanner.nextLine().split(" ");

        int r = Integer.parseInt(rcn[0]);

        int c = Integer.parseInt(rcn[1]);

        int n = Integer.parseInt(rcn[2]);

        String[] grid = new String[r];

        for (int i = 0; i < r; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = bomberMan(n, grid);

        for (int i = 0; i < result.length; i++) {
//            bufferedWriter.write(result[i]);
//
//            if (i != result.length - 1) {
//                bufferedWriter.write("\n");
//            }
            System.out.println(result[i]);
        }
        System.out.println();

//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
