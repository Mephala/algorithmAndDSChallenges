package com.gokhanozg.hackerrank.cutTheSticks;

/**
 * Created by Gokhan Ozgozen on 01-Aug-18.
 */
public class TestSol {
    public static void main(String[] args) {
        printArr(Solution.cutTheSticks(new int[]{1, 2, 3}));
        printArr(Solution.cutTheSticks(new int[]{1, 1, 1}));
        printArr(Solution.cutTheSticks(new int[]{1, 2}));
        printArr(Solution.cutTheSticks(new int[]{1, 2, 3, 3, 3, 3, 4}));
    }

    static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("************");
    }
}
