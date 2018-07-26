package com.gokhanozg.codility.dynamicProgramming.numberSolitaire;

/**
 * Created by Gokhan Ozgozen on 17-Jul-18.
 */
public class TestSol {

    public static void main(String[] args) {
        System.out.println("8," + new Solution().solution(new int[]{1, -2, 0, 9, -1, -2}));
        System.out.println("-99," + new Solution().solution(new int[]{1, -100}));
        System.out.println("900 binli biseyler," + new Solution().solution(new int[]{1, 9000, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}));
        System.out.println("55," + new Solution().solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        System.out.println("46," + new Solution().solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, -9, 10}));
        System.out.println("367," + new Solution().solution(new int[]{1, -2, -3, -4, -5, -6, 100, 150, -9, -10, -11, 100, -13, -14, 16}));
        System.out.println("8036," + new Solution().solution(new int[]{1, 2, 3, 4000, 5, 6, -8000, -8000, -8000, -8000, -8000, 1, -8000, -8000, -8000, -8000, -8000, 6, 5, 4000, 4, 2, 1}));
        System.out.println("8036," + new Solution().solution(new int[]{1, 2, 3, 4000, 5, 6, -8000, -8000, -8000, -8000, -8000, 1, -8000, -8000, -8000, -8000, -8000, 6, 5, 4000, 4, 2, 1}));
        System.out.println("-6," + new Solution().solution(new int[]{-1, -2, -3, -4, -3, -8, -5, -2, -3, -4, -5, -6, -1}));
    }
}
