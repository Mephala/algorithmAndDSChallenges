package com.gokhanozg.fund.selectionSort;

/**
 * Created by Gokhan Ozgozen on 13-Aug-18.
 */
public class SelectionSortTest {

    public static void main(String[] args) {
        printarr(selectionSort(new int[]{3, 4, 2, 1, 5, 7, 4, 2, 1}));
    }

    private static int[] selectionSort(int[] a) {

        for (int i = 0; i < a.length - 1; i++) {
            int min = a[i];
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = a[i];
                a[i] = min;
                a[minIndex] = tmp;
            }
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
