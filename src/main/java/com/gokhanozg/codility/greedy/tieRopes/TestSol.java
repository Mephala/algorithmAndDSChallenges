package com.gokhanozg.codility.greedy.tieRopes;

/**
 * Created by Gokhan Ozgozen on 15-Jul-18.
 */
public class TestSol {
    public static void main(String[] args) {
        System.out.println("3," + new Solution().solution(4, new int[]{1, 2, 3, 4, 1, 1, 3}));
        System.out.println("5," + new Solution().solution(2, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println("5," + new Solution().solution(2, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println("3," + new Solution().solution(5, new int[]{1, 1, 1, 1, 4, 4, 3, 2, 1, 1, 1}));
    }
}
