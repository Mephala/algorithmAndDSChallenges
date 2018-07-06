package com.gokhanozg.codility.maxSliceProblem.maxDoubleSliceSum;

/**
 * Created by Mephalay on 7/5/18.
 */
public class TestSol {

    public static void main(String[] args) {
        System.out.println("17," + new Solution().solution(new int[]{3, 2, 6, -1, 4, 5, -1, 2}));
        System.out.println("0," + new Solution().solution(new int[]{2, 4, -5}));
        System.out.println("505," + new Solution().solution(new int[]{1, 1, 1, 1, 1, -100, 1, 500, -1000, 9}));
        System.out.println("505," + new Solution().solution(new int[]{1, 1, -10, 2, -100, 3, 4, 5, -90, 10000}));
    }
}
