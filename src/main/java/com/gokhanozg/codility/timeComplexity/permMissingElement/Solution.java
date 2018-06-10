package com.gokhanozg.codility.timeComplexity.permMissingElement;

class Solution {
    public int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length + 1;
        long perfectSum = n * (n + 1) / 2;
        long currentSum = 0;
        for (int i : A) {
            currentSum += i;
        }
        return (int) (perfectSum - currentSum);
    }
}