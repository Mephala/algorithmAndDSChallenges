package com.gokhanozg.hackerrank.sumVsXor;

/**
 * Created by Gokhan Ozgozen on 14-Aug-18.
 */
public class TestSol {

    public static void main(String[] args) {
        long count = 0L;
        final int n = 21349;
        for (int i = 0; i <= n; i++) {
            if (i + n == (i ^ n)) {
//                System.out.println(i);
                count++;
            }
        }
        System.out.println(count);
        System.out.println(Solution.solve(n));
    }
}
