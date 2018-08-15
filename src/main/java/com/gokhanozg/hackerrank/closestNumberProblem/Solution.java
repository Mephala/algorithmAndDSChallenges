package com.gokhanozg.hackerrank.closestNumberProblem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the closestNumbers function below.
    static int[] closestNumbers(int[] arr) {
        int minDif = Integer.MAX_VALUE;
        List<Integer> minIndexes = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            int val = arr[i];
            int nextVal = arr[i + 1];
            int diff = Math.abs(val - nextVal);
            if (diff < minDif) {
                minIndexes.clear();
                minIndexes.add(i);
                minDif = diff;
            } else if (diff == minDif) {
                minIndexes.add(i);
            }
        }
        int[] r = new int[minIndexes.size() * 2];
        int i = 0;
        for (Integer index : minIndexes) {
            r[i] = arr[index];
            i++;
            r[i] = arr[index + 1];
            i++;
        }
        return r;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = closestNumbers(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
