package com.gokhanozg.hackerrank.minimumDistances;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        int minDis = Integer.MAX_VALUE;
        boolean minExists = false;
        for (int i = 0; i < a.length; i++) {
            if (valueIndexMap.containsKey(a[i])) {
                minExists = true;
                int dis = i - valueIndexMap.get(a[i]);
                minDis = Math.min(minDis, dis);
                valueIndexMap.put(a[i], i);
            } else {
                valueIndexMap.put(a[i], i);
            }
        }
        if (!minExists)
            return -1;
        return minDis;
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

        int result = minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
