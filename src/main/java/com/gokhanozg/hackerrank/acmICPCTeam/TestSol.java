package com.gokhanozg.hackerrank.acmICPCTeam;

/**
 * Created by Gokhan Ozgozen on 01-Aug-18.
 */
public class TestSol {
    public static void main(String[] args) {
        print(Solution.acmTeam(new String[]{"10101", "11100", "11010", "00101"}));
    }

    static void print(int[] a) {
        for (int i : a) {
            System.out.println(i);
        }
        System.out.println("**********");
    }
}
