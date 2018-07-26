package com.gokhanozg.codility.maxSliceProblem.maxSliceSum;

/**
 * Created by Gokhan Ozgozen on 11-Jul-18.
 */
public class TestSol {
    public static void main(String[] args) {
        System.out.println("5," + new Solution().solution(new int[]{3, 2, -6, 4, 0}));
        System.out.println("1," + new Solution().solution(new int[]{1}));
        System.out.println("400," + new Solution().solution(new int[]{-1, -2, 400, -90, -100}));
    }
}
