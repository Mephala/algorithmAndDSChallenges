package com.gokhanozg.hackerrank.flatlandSpaceStations;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
        Arrays.sort(c);
        if (c.length == 1) {
            if (n % 2 == 0) {
                if (c[0] <= n / 2) {
                    return (n - 1) - c[0];
                } else {
                    return c[0];
                }
            } else {
                int mid = (n / 2) + 1;
                return c[0] <= mid ? (n - 1) - c[0] : c[0];
            }
        } else {
            int prev = c[0];
            int next = c[1];
            int max = 0;
            int index = 2;
            for (int i = 0; i < n; i++) {
                if (i < prev) {
                    max = Math.max(max, prev - i);
                } else if (i == prev) {
                    //do nothing
                } else if (i > prev && i < next) {
                    int dif = Math.min(i - prev, next - i);
                    max = Math.max(dif, max);
                } else if (i == next) {
                    prev = next;
                    if (index != c.length) {
                        next = c[index];
                        index++;
                    }
                } else if (i > prev && i > next) {
                    int dif = i - prev;
                    max = Math.max(max, dif);
                }

            }
            return max;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
