package com.gokhanozg.hackerrank.threeDSurfaceArea;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the surfaceArea function below.
    static int surfaceArea(int[][] A) {
        Stack<Integer> countingStack = new Stack<>();
        int count = 0;
        //left to right
        for (int i = 0; i < A.length; i++) {
            countingStack.push(0);
            for (int j = 0; j < A[0].length; j++) {
                int val = A[i][j];
                if (val > countingStack.peek()) {
                    count += val - countingStack.peek();
                }
                countingStack.push(val);
            }
        }
        //right to left
        for (int i = 0; i < A.length; i++) {
            countingStack.push(0);
            for (int j = A[0].length - 1; j >= 0; j--) {
                int val = A[i][j];
                if (val > countingStack.peek()) {
                    count += val - countingStack.peek();
                }
                countingStack.push(val);
            }
        }
        //front to back
        for (int i = 0; i < A[0].length; i++) {
            countingStack.push(0);
            for (int j = 0; j < A.length; j++) {
                int val = A[j][i];
                if (val > countingStack.peek()) {
                    count += val - countingStack.peek();
                }
                countingStack.push(val);
            }
        }
        //back to front
        for (int i = 0; i < A[0].length; i++) {
            countingStack.push(0);
            for (int j = A.length - 1; j >= 0; j--) {
                int val = A[j][i];
                if (val > countingStack.peek()) {
                    count += val - countingStack.peek();
                }
                countingStack.push(val);
            }
        }
        int nonZeroVals = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                int val = A[i][j];
                if (val > 0) {
                    nonZeroVals++;
                }
            }
        }
        count += 2 * nonZeroVals; // from top and bottom should be equal.

        return count;

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] HW = scanner.nextLine().split(" ");

        int H = Integer.parseInt(HW[0]);

        int W = Integer.parseInt(HW[1]);

        int[][] A = new int[H][W];

        for (int i = 0; i < H; i++) {
            String[] ARowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < W; j++) {
                int AItem = Integer.parseInt(ARowItems[j]);
                A[i][j] = AItem;
            }
        }

        int result = surfaceArea(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
