package com.gokhanozg.codility.arrays.oddOccurencesInArray;

public class TestSol {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {9, 3, 9, 9, 7, 9, 3};
        System.out.println(solution.solution(A));
        int[] B = {1};
        System.out.println(solution.solution(B));
        int[] C = {1, 2, 1};
        System.out.println(solution.solution(C));
        int[] D = {1, 2, 1, 2, 3, 4, 4, 3, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 11, 12, 10, 12, 13, 13, 14, 14, 15, 15, 16, 16, 17, 17};
        System.out.println(solution.solution(D));

    }
}
