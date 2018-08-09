package com.gokhanozg.hackerrank.larrysArray;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the larrysArray function below.
    static String larrysArray(int[] A) {
        int[] sorted = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            sorted[i] = A[i];
        }
        Arrays.sort(sorted);
        for (int i = 0; i < sorted.length - 2; i++) {
            int[] sortedSlice = Arrays.copyOfRange(sorted, i, i + 3);
            int[] aSlice = Arrays.copyOfRange(A, i, i + 3);
            int attempt = 0;
            while (attempt < 3 && sortedSlice[0] != aSlice[0]) {
                aSlice = rotate(aSlice);
                attempt++;
            }
            if (sortedSlice[0] != aSlice[0]) {
                return "NO";
            }
            A[i] = aSlice[0];
            A[i + 1] = aSlice[1];
            A[i + 2] = aSlice[2];
        }
        if (Arrays.equals(sorted, A)) {
            return "YES";
        }
        return "NO";
    }

    static int[] rotate(int[] a) {
        int[] ret = new int[3];
        ret[0] = a[1];
        ret[1] = a[2];
        ret[2] = a[0];
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] A = new int[n];

            String[] AItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int AItem = Integer.parseInt(AItems[i]);
                A[i] = AItem;
            }

            String result = larrysArray(A);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
