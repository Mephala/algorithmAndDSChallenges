package com.gokhanozg.hackerrank.sorting.insertionSort1;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the insertionSort1 function below.
    static void insertionSort1(int n, int[] arr) {
        int rightMost = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > rightMost) {
                arr[i + 1] = arr[i];
            } else {
                arr[i + 1] = rightMost;
                break;
            }
            printarr(arr);
        }
        if (arr[0] > rightMost) {
            arr[0] = rightMost;
        }
        printarr(arr);

    }

    static void printarr(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i + " ");
        }
        System.out.println(sb.toString().trim());
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

        insertionSort1(n, arr);

        scanner.close();
    }
}
