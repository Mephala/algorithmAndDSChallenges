package com.gokhanozg.codility.dynamicProgramming.minAbs;

/**
 * Created by Gokhan Ozgozen on 19-Jul-18.
 */
public class TestSol {
    public static void main(String[] args) {
        System.out.println("0," + new Solution().solution(new int[]{1, 1, 1, 1, 1, 3, 2}));
        System.out.println("0," + new Solution().solution(new int[]{3, 2, 2, 1}));
        System.out.println("1," + new Solution().solution(new int[]{3, 2}));
        System.out.println("0," + new Solution().solution(new int[]{1, 2, 5, 8}));
        System.out.println("1," + new Solution().solution(new int[]{1, 2, 5, 8, 3}));
        System.out.println("0," + new Solution().solution(new int[]{1, -2, 5, 8}));
        System.out.println("0," + new Solution().solution(new int[]{1, 5, -2, 2}));
        System.out.println("0," + new Solution().solution(new int[]{2, 2, 3, 3, 8, 2, 2}));
        System.out.println("2," + new Solution().solution(new int[]{4, 9, 1, 5, 20, 14, 6, 7}));
        System.out.println("0," + new Solution().solution(new int[]{}));
        System.out.println("6," + new Solution().solution(new int[]{6}));
        System.out.println("500," + new Solution().solution(new int[]{100, 700, 100}));
        System.out.println("0," + new Solution().solution(new int[]{1, 5, -2, 5, 2, 3}));
        System.out.println("0," + new Solution().solution(new int[]{1, 2, 3, 4, 1, 1}));
    }
}
