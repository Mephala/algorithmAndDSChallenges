package com.gokhanozg.codility.timeComplexity.permMissingElement;

public class TestSol {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int A[] = {2, 3, 1, 5};
        System.out.println(solution.solution(A));
        int B[] = {};
        System.out.println(solution.solution(B));
        int C[] = {2};
        System.out.println(solution.solution(C));
        int D[] = {1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        System.out.println(solution.solution(D));
        int E[] = {1, 3};
        System.out.println(solution.solution(E));
        int F[] = {2, 3};
        System.out.println(solution.solution(F));
    }
}
