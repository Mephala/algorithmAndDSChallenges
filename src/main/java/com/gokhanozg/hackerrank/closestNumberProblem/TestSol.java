package com.gokhanozg.hackerrank.closestNumberProblem;

/**
 * Created by Gokhan Ozgozen on 15-Aug-18.
 */
public class TestSol {

    public static void main(String[] args) {
        printA(Solution.closestNumbers(new int[]{-5, 15, 25, 71, 63}));
    }

    static void printA(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("*********");
    }
}
