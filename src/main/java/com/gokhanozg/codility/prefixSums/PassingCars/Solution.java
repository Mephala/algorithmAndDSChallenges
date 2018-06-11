package com.gokhanozg.codility.prefixSums.PassingCars;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int[] prefixSum = new int[A.length];
        final int limit = (int) 1E9;
        int n = A.length;
        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                prefixSum[0] = A[0];
            } else {
                prefixSum[i] = prefixSum[i - 1] + A[i];
            }
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] == 0) {
                total = total + (i == 0 ? prefixSum[n - 1] : prefixSum[n - 1] - prefixSum[i - 1]);
            }
            if (total > limit)
                return -1;
        }
        return total;
    }
}