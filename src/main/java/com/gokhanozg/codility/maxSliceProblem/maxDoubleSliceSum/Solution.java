package com.gokhanozg.codility.maxSliceProblem.maxDoubleSliceSum;

class Solution {
    public int solution(int[] A) {
        int[] B = new int[A.length - 2];
        for (int i = 0; i < B.length; i++) {
            B[i] = A[i + 1];
        }
        long maxEnd = 0L;
        long maxSlice = 0L;
        int maxSliceStartIndex = -1;
        int maxSliceEndIndex = 0;
        int currentSliceStartIndex = 0;
        int currentSliceEndIndex = -1;
        for (int i = 0; i < B.length; i++) {
            if (maxEnd + B[i] > 0) {
                maxEnd += B[i];
                currentSliceEndIndex = i;
            } else {
                maxEnd = 0;
                currentSliceEndIndex = i - 1;
                currentSliceStartIndex = i + 1;
            }
            if (maxSlice < maxEnd) {
                maxSliceStartIndex = currentSliceStartIndex;
                maxSliceEndIndex = currentSliceEndIndex;
                maxSlice = maxEnd;
            }
        }
        int lowest = Integer.MAX_VALUE;
        for (int i = maxSliceStartIndex; i <= maxSliceEndIndex; i++) {
            if (B[i] < lowest)
                lowest = B[i];
        }
        if (lowest == Integer.MAX_VALUE)
            lowest = 0; // N = 3 case normalization.
        return (int) (maxSlice - lowest);
    }
}