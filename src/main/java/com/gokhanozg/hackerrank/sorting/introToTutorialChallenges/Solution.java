package com.gokhanozg.hackerrank.sorting.introToTutorialChallenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the introTutorial function below.
    static int introTutorial(int V, int[] arr) {
        // Pre-sorted, binary search is the way to go.
        return getValIndex(arr.length / 2, V, arr.length / 4, arr);
    }

    static int getValIndex(int index, int V, int incrementation, int[] arr) {
        if (incrementation == 0)
            incrementation = 1;
        int midPoint = arr[index];
        if (midPoint == V)
            return index;
        if (midPoint > V) {
            //go left
            index = index - incrementation;
            return getValIndex(index, V, incrementation / 2, arr);
        } else {
            index = index + incrementation;
            return getValIndex(index, V, incrementation / 2, arr);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int V = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = introTutorial(V, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
