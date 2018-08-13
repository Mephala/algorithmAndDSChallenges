package com.gokhanozg.hackerrank.almostSorted;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the almostSorted function below.
    static void almostSorted(int[] arr) {
        Map<Integer, Integer> swaps = new HashMap<>();
        int swapsNeeded = 0;
        int[] sorted = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sorted[i] = arr[i];
        }
        Arrays.sort(sorted);
        int min = arr.length;
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            int corPos = Arrays.binarySearch(sorted, arr[i]);
            if (i != corPos) {
                if (!swaps.containsKey(corPos)) {
                    swapsNeeded++;
                    swaps.put(i, corPos);
                    min = Math.min(min, i);
                    max = Math.max(max, corPos);
                }

            }
        }
        if (swapsNeeded == 1) {
            Map.Entry entry = swaps.entrySet().iterator().next();
            int key = (int) entry.getKey();
            int val = (int) entry.getValue();
            key++;
            val++;
            System.out.println("yes");
            System.out.println("swap " + key + " " + val);
        } else if (swapsNeeded == 0) {
            System.out.println("yes");
        } else {
            int[] reverseSegment = new int[max - min + 1];
            for (int i = min; i <= max; i++) {
                reverseSegment[i - min] = arr[i];
            }
            int[] reverse = new int[reverseSegment.length];
            for (int i = 0; i < reverse.length; i++) {
                reverse[i] = reverseSegment[reverse.length - 1 - i];
            }
            Arrays.sort(reverseSegment);
            if (Arrays.equals(reverse, reverseSegment)) {
                min++;
                max++;
                System.out.println("yes");
                System.out.println("reverse " + min + " " + max);
            } else {
                System.out.println("no");
            }
        }
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

        almostSorted(arr);

        scanner.close();
    }
}
