package com.gokhanozg.codility.prefixSums.countDiv;

class Solution {
    public int solution(int A, int B, int K) {
        int modA = A % K;
        int modB = B % K;
        int start = 0;
        int end = 0;
        if (modA == 0) {
            start = A / K;
        } else if (modA != 0) {
            int tmp = A + (K - modA);
            if (tmp > B) {
                return 0;
            } else {
                start = tmp / K;
            }
        }
        if (modB == 0) {
            end = B / K;
        } else if (modB != 0) {
            int tmp = B - modB;
            if (tmp < A) {
                return 0;
            } else {
                end = tmp / K;
            }
        }
        return end - start + 1;

    }
}