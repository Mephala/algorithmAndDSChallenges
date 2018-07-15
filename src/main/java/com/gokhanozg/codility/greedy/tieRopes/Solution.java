package com.gokhanozg.codility.greedy.tieRopes;

class Solution {
    public int solution(int K, int[] A) {
        int count = 0;
        long tmpSum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= K) {
                count++;
                continue;
            } else {
                tmpSum += A[i];
            }
            if (tmpSum >= K) {
                tmpSum = 0;
                count++;
            }
        }
        return count;
    }
}