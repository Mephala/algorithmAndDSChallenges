package com.gokhanozg.fund.problems.p2;

/**
 * Created by Gokhan Ozgozen on 18-Aug-18.
 */
public class TestSol {


    public static void main(String[] args) {
//        printA(new Solution().solution(new int[]{9, 1, 4, 9, 0, 4, 8, 9, 0, 1}));
//        printA(new Solution().solution(new int[]{0, 0, 0, 0, 0, 4, 3, 1, 2}));
//        printA(new Solution().solution(new int[]{0}));
        printA(new Solution().solution(new int[]{0, 0}));
    }

    private static void printA(int[] a) {
        for (int i : a) {
            System.out.println(i);
        }
        System.out.println("********");
    }
}
