package com.gokhanozg.codility.timeComplexity.tapeEquilibrium;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        int lowestDif = Integer.MAX_VALUE;
        int N = A.length;
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                left[i] = A[i];
                right[N - 1 - i] = A[N - 1 - i];
            } else {
                left[i] = A[i] + left[i - 1];
                right[N - 1 - i] = right[N - 1 - i + 1] + A[N - 1 - i];
            }
        }
        for (int i = 1; i <= N - 1; i++) {
            int diff = Math.abs(left[i - 1] - right[i]);
            if (diff < lowestDif)
                lowestDif = diff;
        }
        return lowestDif;
    }
}