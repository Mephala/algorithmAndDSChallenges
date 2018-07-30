package com.gokhanozg.hackerrank.betweenTwoSets;

/**
 * Created by Gokhan Ozgozen on 30-Jul-18.
 */
public class TestSol {

    public static void main(String[] args) {
        System.out.println("2," + Solution.getTotalX(new int[]{2, 6}, new int[]{24, 36}));
        System.out.println("3," + Solution.getTotalX(new int[]{2, 4}, new int[]{16, 32, 96}));
        System.out.println("1," + Solution.getTotalX(new int[]{2}, new int[]{20, 30, 12}));
        System.out.println("2," + Solution.getTotalX(new int[]{3, 9, 6}, new int[]{36, 72}));
    }
}
