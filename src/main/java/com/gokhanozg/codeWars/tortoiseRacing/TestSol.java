package com.gokhanozg.codeWars.tortoiseRacing;

/**
 * Created by Gokhan Ozgozen on 12-Aug-18.
 */
public class TestSol {
    public static void main(String[] args) {
        printArr(Tortoise.race(720, 850, 70));
    }

    static void printArr(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("**********");
    }
}
