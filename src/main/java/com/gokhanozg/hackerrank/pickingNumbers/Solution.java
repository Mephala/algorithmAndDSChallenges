package com.gokhanozg.hackerrank.pickingNumbers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the pickingNumbers function below.
    static int pickingNumbers(int[] a) {
        Map<Integer, Integer> occurence = new HashMap<>();
        Set<Integer> vals = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            occurence.put(a[i], occurence.getOrDefault(a[i], 0) + 1);
            vals.add(a[i]);
        }
        int max = 0;
        for (Integer val : vals) {
            int total = Math.max(occurence.get(val) + occurence.getOrDefault(val - 1, 0), occurence.get(val) + occurence.getOrDefault(val + 1, 0));
            max = Math.max(total, max);
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
