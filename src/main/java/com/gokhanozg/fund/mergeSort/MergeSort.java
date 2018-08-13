package com.gokhanozg.fund.mergeSort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Gokhan Ozgozen on 13-Aug-18.
 */
public class MergeSort {


    public static void main(String[] args) {
        final int len = (int) 1000000;
        Random r = new Random();
        int[] ints = new int[len];
        for (int i = 0; i < len; i++) {
            ints[i] = r.nextInt();
        }

//        printarr(mergeSort(new int[]{3, 4, 2, 1, 5, 7, 4, 2, 1}));
        long start = System.nanoTime();
        mergeSort(ints);
        long differ = System.nanoTime() - start;
        System.out.println("Custom merge sort nano time:" + differ);
        start = System.nanoTime();
        Arrays.sort(ints);
        differ = System.nanoTime() - start;
        System.out.println("Java   merge sort nano time:" + differ);

    }

    private static int[] mergeSort(int[] ints) {
        sort(ints, 0, ints.length - 1);
        return ints;
    }


    private static void printarr(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();
    }


    private static void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    private static void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}
