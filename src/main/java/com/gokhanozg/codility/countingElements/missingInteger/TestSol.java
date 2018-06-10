package com.gokhanozg.codility.countingElements.missingInteger;

public class TestSol {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1, 3, 6, 4, 1, 2}));
        System.out.println(new Solution().solution(new int[]{2}));
        System.out.println(new Solution().solution(new int[]{900, 23223}));
        System.out.println(new Solution().solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 13, 13, 13, 14, 15, 15, 16, 17, 90}));
        System.out.println(new Solution().solution(new int[]{1, 2, 3}));
        System.out.println(new Solution().solution(new int[]{-1, -3}));
    }
}
