package com.gokhanozg.hackerrank.weightedUniformString;

/**
 * Created by Gokhan Ozgozen on 14-Aug-18.
 */
public class TestSol {

    public static void main(String[] args) {
        printA(Solution.weightedUniformStrings("abccddde", new int[]{6, 1, 3, 12, 5, 9, 10}));
    }

    static void printA(String[] a) {
        for (String s : a) {
            System.out.println(s);
        }
        System.out.println("**************");
    }
}
