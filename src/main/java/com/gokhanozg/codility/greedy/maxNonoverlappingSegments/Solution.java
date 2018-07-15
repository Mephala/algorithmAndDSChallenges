package com.gokhanozg.codility.greedy.maxNonoverlappingSegments;

class Solution {
    public int solution(int[] A, int[] B) {
        int count = 0;
        int end = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > end) {
                count++;
                end = B[i];
            } else {
                end = Math.min(B[i], end);
            }
        }
        return count;
    }


}