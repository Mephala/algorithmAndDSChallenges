package com.gokhanozg.hackerrank.circularArrayRot;

/**
 * Created by Gokhan Ozgozen on 31-Jul-18.
 */
public class TestSol {

    public static void main(String[] args) {
        printArr(Solution.circularArrayRotation(new int[]{1, 2, 3}, 2, new int[]{0, 1, 2}));
    }

    static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("********");
    }
}
