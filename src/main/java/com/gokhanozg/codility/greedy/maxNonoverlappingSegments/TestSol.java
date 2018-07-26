package com.gokhanozg.codility.greedy.maxNonoverlappingSegments;

/**
 * Created by Gokhan Ozgozen on 15-Jul-18.
 */
public class TestSol {

    public static void main(String[] args) {
        System.out.println("3," + new Solution().solution(new int[]{1, 3, 7, 9, 9,}, new int[]{5, 6, 8, 9, 10}));
        System.out.println("3," + new Solution().solution(new int[]{1, 3, 7, 10, 14,}, new int[]{5, 8, 11, 14, 15}));
        System.out.println("4," + new Solution().solution(new int[]{1, 2, 3, 4, 5,}, new int[]{100, 2, 3, 4, 5}));
        System.out.println("1," + new Solution().solution(new int[]{1, 2}, new int[]{2, 2}));
        System.out.println("1," + new Solution().solution(new int[]{1, 2}, new int[]{2, 2}));
        System.out.println("3," + new Solution().solution(new int[]{1, 2, 3, 4}, new int[]{6, 7, 10, 18}));
    }
}
