package com.gokhanozg.codility.stackAndQueue.fish;

/**
 * Created by Gokhan Ozgozen on 27-Jun-18.
 */
public class TestSol {

    public static void main(String[] args) {
        System.out.println("2," + new Solution().solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0}));
        System.out.println("1," + new Solution().solution(new int[]{8}, new int[]{1}));
        System.out.println("1," + new Solution().solution(new int[]{8}, new int[]{0}));
        System.out.println("2," + new Solution().solution(new int[]{4, 3, 2, 1, 5, 7}, new int[]{1, 1, 1, 0, 0, 0}));
        System.out.println("6," + new Solution().solution(new int[]{4, 3, 2, 1, 5, 7}, new int[]{1, 1, 1, 1, 1, 1}));
        System.out.println("6," + new Solution().solution(new int[]{4, 3, 2, 1, 5, 7}, new int[]{0, 0, 0, 0, 0, 0}));
        System.out.println("5," + new Solution().solution(new int[]{4, 3, 2, 1, 5, 7}, new int[]{0, 0, 0, 0, 1, 0}));
        System.out.println("4," + new Solution().solution(new int[]{8, 5, 9, 6, 7, 78}, new int[]{0, 1, 0, 1, 0, 1}));
    }
}
