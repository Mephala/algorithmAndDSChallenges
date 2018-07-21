package com.gokhanozg.hackerrank.maxArraySum;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the maxSubsetSum function below.
    //https://www.hackerrank.com/challenges/max-array-sum/problem
    public static int maxSubsetSum(int[] arr) {
        long[] sums = new long[arr.length];
        boolean prevElementInList = true;
        int max = Integer.MIN_VALUE;
        sums[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (!prevElementInList) {
                long tmpSum = sums[i - 1] + arr[i];
                tmpSum = Math.max(arr[i], tmpSum);
                if (tmpSum > sums[i - 1]) {
                    sums[i] = tmpSum;
                    prevElementInList = true;
                } else {
                    sums[i] = sums[i - 1];
                    prevElementInList = false;
                }
            } else {
                if (i == 1) {
                    if (arr[1] > arr[0]) {
                        sums[1] = arr[1];
                        prevElementInList = true;
                    } else {
                        sums[1] = sums[0];
                        prevElementInList = false;
                    }
                } else {
                    long tmpSum = sums[i - 2] + arr[i];
                    tmpSum = Math.max(arr[i], tmpSum);
                    if (tmpSum > sums[i - 1]) {
                        //removing previous element and adding this one.
                        sums[i] = tmpSum;
                        prevElementInList = true;
                    } else {
                        prevElementInList = false; // not using this one.
                        sums[i] = sums[i - 1];
                    }
                }
            }
            max = Math.max(arr[i], max);
        }

        return (int) Math.max(sums[arr.length - 1], max);
    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
        System.out.println(res);

        scanner.close();
    }
}
