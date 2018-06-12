package com.gokhanozg.codility.sorting.numberOfDiscIntersections;

public class TestSol {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1, 5, 2, 1, 4, 0}));
        System.out.println(new Solution().solution(new int[]{1, 0, 1}));
        System.out.println(new Solution().solution(new int[]{0, 0, 0}));
        System.out.println(new Solution().solution(new int[]{}));
        System.out.println(new Solution().solution(new int[]{3, 0, 0, 0, 0, 0, 3}));
        int[] K = new int[(int) 1E5];
        for (int i = 0; i < 1E5; i++) {
            K[i] = 0;
        }
        System.out.println(new Solution().solution(K));
        long k = Integer.MAX_VALUE + 18;
        System.out.println(k);
        k = (long) Integer.MAX_VALUE + (long) 18;
        System.out.println(k);
    }
}
