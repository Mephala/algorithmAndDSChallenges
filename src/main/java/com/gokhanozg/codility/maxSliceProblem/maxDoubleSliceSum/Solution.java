package com.gokhanozg.codility.maxSliceProblem.maxDoubleSliceSum;

class Solution {
    public int solution(int[] A) {
        int[] B = new int[A.length - 2];
        for (int i = 0; i < B.length; i++) {
            B[i] = A[i + 1];
        }
        A = B;
        long maxEnd = 0L;
        long maxSlice = 0L;
        int elementCountInSlice = 0;
        long grandMaxSlice = 0L;
        int startIndex = -1;
        int endIndex = -1;
        for (int i = 0; i < B.length; i++) {
            maxEnd = Math.max(0, maxEnd + A[i]);
            if (B[i] != 0 && maxEnd == 0L) {
                elementCountInSlice = 0;
                startIndex = -1;
            } else {
                elementCountInSlice++;
                if (startIndex == -1) {
                    startIndex = i;
                } else {
                    endIndex = i;
                }
            }
            maxSlice = Math.max(maxSlice, maxEnd);
            if (maxSlice > maxEnd)
                endIndex--;
            if (elementCountInSlice >= 3 && maxSlice > grandMaxSlice) {
                grandMaxSlice = maxSlice;
            }
        }
        int lowest = Integer.MAX_VALUE;
        for (int i = startIndex; i <= endIndex; i++) {
            if (B[i] < lowest)
                lowest = B[i];
        }
        if (lowest == Integer.MAX_VALUE)
            lowest = 0; // N = 3 case normalization.
        return (int) (grandMaxSlice - lowest);
    }
}