package com.gokhanozg.codility.maxSliceProblem.maxProfit;

class Solution {
    public int solution(int[] A) {
        int[] leftMinArr = new int[A.length];
        int[] rightMaxArr = new int[A.length];
        int leftMin = Integer.MAX_VALUE;
        int rightMax = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            leftMin = Math.min(leftMin, A[i]);
            leftMinArr[i] = leftMin;
        }
        for (int i = A.length - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, A[i]);
            rightMaxArr[i] = rightMax;
        }
        int maxDif = 0;
        for (int i = 0; i < A.length - 1; i++) {
            maxDif = Math.max(maxDif, rightMaxArr[i + 1] - leftMinArr[i]);
        }
        return maxDif;
    }
}