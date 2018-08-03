package com.gokhanozg.hackerrank.manasaAndStones;

/**
 * Created by Gokhan Ozgozen on 03-Aug-18.
 */
public class TestSol {

    public static void main(String[] args) {
        printArr(Solution.stones(4, 10, 100));
    }

    static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("******");
    }
}
