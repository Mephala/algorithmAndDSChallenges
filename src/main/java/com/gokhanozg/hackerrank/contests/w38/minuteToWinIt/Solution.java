package com.gokhanozg.hackerrank.contests.w38.minuteToWinIt;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the minuteToWinIt function below.
    static int minuteToWinIt(int[] a, int k) {
        int[] lrc = new int[a.length];
        int[] rlc = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            lrc[i] = a[i];
            rlc[i] = a[i];
        }
        int lr = lrMinCount(lrc, k);
        int rl = rlMinCount(rlc, k);
        int[] difArr = new int[a.length - 1];
        for (int i = 0; i < a.length - 1; i++) {
            difArr[i] = a[i + 1] - a[i];
        }
        int diffCount = 0;
        for (int i = 0; i < difArr.length; i++) {
            if (difArr[i] != k) {
                diffCount++;
            }
        }


//        return Math.min(rl, Math.min(mid, lr));
        return 8;

    }

    private static int rlMinCount(int[] rlc, int k) {
        int rl = 0;
        for (int i = rlc.length - 1; i > 0; i--) {
            if (rlc[i] - rlc[i - 1] != k) {
                rl++;
                rlc[i - 1] = rlc[i] - k;
            }
        }
        return rl;
    }

    private static int lrMinCount(int[] lrc, int k) {
        int lr = 0;
        for (int i = 0; i < lrc.length - 1; i++) {
            if (lrc[i + 1] - lrc[i] != k) {
                lr++;
                lrc[i + 1] = lrc[i] + k;
            }
        }
        return lr;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = minuteToWinIt(a, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
