package com.gokhanozg.codility.maxSliceProblem.maxProfit;

/**
 * Created by Mephalay on 11-Jul-18.
 */
public class TestSol {

    public static void main(String[] args) {
        System.out.println("356," + new Solution().solution(new int[]{23171, 21011, 21123, 21366, 21013, 21367}));
        System.out.println("0," + new Solution().solution(new int[]{}));
        System.out.println("0," + new Solution().solution(new int[]{6, 5, 4, 3, 2, 1}));
        System.out.println("0," + new Solution().solution(new int[]{2, 1}));
        System.out.println("1," + new Solution().solution(new int[]{1, 2}));
        System.out.println("0," + new Solution().solution(new int[]{0, 0}));
    }
}
