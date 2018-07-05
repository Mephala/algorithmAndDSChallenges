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
        for (int i = 0; i < A.length; i++) {
            maxEnd = Math.max(0, maxEnd + A[i]);
            if (A[i] != 0 && maxEnd == 0L) {
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
            if (elementCountInSlice >= 3 && maxSlice > grandMaxSlice) {
                grandMaxSlice = maxSlice;
            }
        }
        return (int) grandMaxSlice;
    }
}