package com.gokhanozg.codility.floodDepth;

/**
 * Created by Gokhan Ozgozen on 18-Aug-18.
 */
public class TestSol {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2}));
        System.out.println(new Solution().solution(new int[]{1, 2, 3}));
        System.out.println(new Solution().solution(new int[]{1, 2, 3, 100, 50, 0, 1}));
        System.out.println(new Solution().solution(new int[]{1, 2, 3, 100, 75, 99, 0, 29}));
        System.out.println(new Solution().solution(new int[]{5, 5, 5, 5, 5, 5, 5, 5, 6, 5, 6}));
        System.out.println(new Solution().solution(new int[]{5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6}));
    }
}
