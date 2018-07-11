package com.gokhanozg.codility.maxSliceProblem.maxSliceSum;

class Solution {
    public int solution(int[] A) {
        long maxSliceSumSoFar = 0L;
        long grandMax = Long.MIN_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            maxSliceSumSoFar = Math.max(0, maxSliceSumSoFar + A[i]);
            grandMax = Math.max(grandMax, maxSliceSumSoFar);
            maxVal = Math.max(maxVal, A[i]);
        }
        if (maxVal < 0) {
            return maxVal;
        }
        return (int) grandMax;
    }
}