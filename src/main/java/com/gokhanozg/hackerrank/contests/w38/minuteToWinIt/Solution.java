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
        Map<Long, Integer> distanceToCountMap = new HashMap<>();
        int maxCount = 0;
        long y = 0L;
        for (int i = 0; i < a.length; i++) {
            y = (long) i * (long) k;
            long distance = y - a[i];
            distanceToCountMap.put(distance, distanceToCountMap.getOrDefault(distance, 0) + 1);
            maxCount = Math.max(distanceToCountMap.get(distance), maxCount);
        }
        return a.length - maxCount;
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
