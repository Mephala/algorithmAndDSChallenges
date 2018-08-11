package com.gokhanozg.codility.dynamicProgramming.minAbs;

class Solution {
    //Fails on one case, achieves almost full score. Don't know yet why it fails. I will update once I have my curiosity
    // is back on this : )

    public int solution(int[] A) {
        int sum = 0;
        for (int i : A) {
            sum += Math.abs(i);
        }
        int half = sum / 2;
        int[] sums = new int[sum + 1];
        sums[0] = 1;
        for (int i = 0; i < sums.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (sums[i] == 1 && (i + A[j]) <= sum) {
                    sums[i + A[j]] = 1;
                }
            }
        }
        for (int i = half; i >= 0; i--) {
            if (sums[i] == 1) {
                return sum - i;
            }
        }
        return -1;
    }


}