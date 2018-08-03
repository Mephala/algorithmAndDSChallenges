package com.gokhanozg.hackerrank.cavityMap;

/**
 * Created by Gokhan Ozgozen on 03-Aug-18.
 */
public class TestSol {

    public static void main(String[] args) {
        printGrid(Solution.cavityMap(new String[]{"1112", "1912", "1892", "1234"}));
    }

    private static void printGrid(String[] grid) {
        for (String s : grid) {
            System.out.println(s);
        }
    }
}
