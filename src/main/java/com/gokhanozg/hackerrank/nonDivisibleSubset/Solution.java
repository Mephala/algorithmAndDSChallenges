package com.gokhanozg.hackerrank.nonDivisibleSubset;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the nonDivisibleSubset function below.
    static int nonDivisibleSubset(int k, int[] S) {
        int[][] dp = new int[S.length][k];
        dp[0][S[0] % k] = 1;
        for (int i = 1; i < S.length; i++) {
            int mod = S[i] % k;
            for (int j = 0; j < k; j++) {
                dp[i][j] = dp[i - 1][j];
            }
            dp[i][mod] = dp[i - 1][mod] + 1;
        }
        int total = 0;
        if (k % 2 == 0) {
            int half = k / 2;
            if (dp[S.length - 1][half] > 0) {
                total++; // adding one from half.
            }
            half--;
            for (int i = 1; i <= half; i++) {
                int max = Math.max(dp[S.length - 1][i], dp[S.length - 1][k - i]);
                total += max;
            }
        } else {
            int half = k / 2;
            for (int i = 1; i <= half; i++) {
                int max = Math.max(dp[S.length - 1][i], dp[S.length - 1][k - i]);
                total += max;
            }
        }
        //we can add one mod 0
        if (dp[S.length - 1][0] > 0) {
            total++; // adding one from half.
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] S = new int[n];

        String[] SItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int SItem = Integer.parseInt(SItems[i]);
            S[i] = SItem;
        }

        int result = nonDivisibleSubset(k, S);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
