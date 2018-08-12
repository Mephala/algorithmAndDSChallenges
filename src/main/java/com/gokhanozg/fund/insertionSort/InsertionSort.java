package com.gokhanozg.fund.insertionSort;

/**
 * Created by Gokhan Ozgozen on 12-Aug-18.
 */
public class InsertionSort {

    public static void main(String[] args) {
        printarr(insort(new int[]{3, 4, 2, 1, 5, 7, 4, 2, 1}));
    }

    private static int[] insort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int val = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > val) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = val;
        }
        return a;
    }

    private static void printarr(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();
    }
}
