package com.gokhanozg.hackerrank.absolutePermutation;

/**
 * Created by Gokhan Ozgozen on 08-Aug-18.
 */
public class TestSol {
    public static void main(String[] args) {
        printArr(Solution.absolutePermutation(4, 2));
        printArr(Solution.absolutePermutation(2, 1));
        printArr(Solution.absolutePermutation(3, 0));
        printArr(Solution.absolutePermutation(3, 2));
    }

    static void printArr(int[] arr) {
        if (arr == null) {
            System.out.println("-1");
        } else {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            System.out.println("***********************");
        }

    }
}
