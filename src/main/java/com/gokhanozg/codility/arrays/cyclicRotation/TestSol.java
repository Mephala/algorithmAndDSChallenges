package com.gokhanozg.codility.arrays.cyclicRotation;

public class TestSol {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        Solution sol = new Solution();
        int[] K = sol.solution(A, 1);
        printArr(K);
        int[] B = {1};
        printArr(sol.solution(B, 1));
        int[] C = {0, 0};
        printArr(sol.solution(C, 1));
        int[] D = {3, 8, 9, 7, 6};
        printArr(sol.solution(D, 3));
    }

    private static void printArr(int[] k) {
        System.out.println("***********************");
        for (int i : k) {
            System.out.println(i);
        }
    }
}
