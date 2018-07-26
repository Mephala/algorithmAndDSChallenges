package com.gokhanozg.codility.caterpillar.countDistinctSlices;

/**
 * Created by Gokhan Ozgozen on 14-Jul-18.
 */
public class TestSol {

    public static void main(String[] args) {
        System.out.println("9," + new Solution().solution(6, new int[]{3, 4, 5, 5, 2}));
        System.out.println("5," + new Solution().solution(6, new int[]{5, 5, 5, 5, 5}));
        System.out.println("1," + new Solution().solution(6, new int[]{1}));
        System.out.println("12," + new Solution().solution(6, new int[]{1, 2, 3, 3, 2, 1}));
        System.out.println("9," + new Solution().solution(6, new int[]{3, 2, 1, 3}));
        System.out.println("7," + new Solution().solution(6, new int[]{1, 2, 3, 3}));
        System.out.println("8," + new Solution().solution(6, new int[]{1, 3, 2, 3}));
    }
}
