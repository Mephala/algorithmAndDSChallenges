package com.gokhanozg.hackerrank.warmup.plusMinusProblem;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        double plus = 0;
        double minus = 0;
        double zero = 0;
        for (int i : arr) {
            if (i < 0) {
                minus++;
            } else if (i > 0) {
                plus++;
            } else {
                zero++;
            }
        }
        double size = arr.length;
        System.out.println(plus / size);
        System.out.println(minus / size);
        System.out.println(zero / size);

    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
