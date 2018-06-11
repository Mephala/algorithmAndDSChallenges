package com.gokhanozg.codility.prefixSums.MushroomPicker;

public class Solution {
    public int solution(int k, int m, int[] A) {
        int[] prefixSum = new int[A.length];
        int n = A.length;
        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                prefixSum[i] = A[i];
            } else {
                prefixSum[i] = prefixSum[i - 1] + A[i];
            }
        }
        int result = 0;
        for (int p = 0; p < Math.min(m, k) + 1; p++) {
            int leftpos = k - p;
            int rightpos = Math.min(n - 1, Math.max(k, k + m - 2 * p));
            result = Math.max(result, countTotal(prefixSum, rightpos, leftpos));
        }
        for (int p = 0; p < Math.min(m + 1, n - k); p++) {
            int rightpos = k + p;
            int leftpos = Math.max(0, Math.min(k, k - (m - 2 * p)));
            result = Math.max(result, countTotal(prefixSum, rightpos, leftpos));
        }
        return result;
    }

    private int countTotal(int[] prefix, int rightPos, int leftPos) {
        if (leftPos == 0) {
            return prefix[rightPos];
        } else {
            return prefix[rightPos] - prefix[leftPos - 1];
        }
    }
}
