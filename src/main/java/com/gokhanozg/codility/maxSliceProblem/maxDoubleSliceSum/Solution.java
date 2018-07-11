package com.gokhanozg.codility.maxSliceProblem.maxDoubleSliceSum;

class Solution {
    public int solution(int[] A) {
        if (A.length == 3)
            return 0;
        long[] lr = new long[A.length - 2];
        long[] rl = new long[A.length - 2];
        long lrMax = 0L;
        long rlMax = 0L;
        for (int i = 0; i < A.length - 2; i++) {
            lrMax = Math.max(0, A[i + 1] + lrMax);
            lr[i] = lrMax;
        }
        for (int i = A.length - 3; i >= 0; i--) {
            rlMax = Math.max(0, rlMax + A[i + 1]);
            rl[i] = rlMax;
        }
        long max = 0L;
        for (int i = 0; i < lr.length; i++) {
            if (i == 0) {
                long dif = rl[i + 1];
                if (dif > max) {
                    max = dif;
                }
            } else if (i == lr.length - 1) {
                long dif = lr[i - 1];
                if (dif > max) {
                    max = dif;
                }
            } else {
                long dif = lr[i - 1] + rl[i + 1];
                if (dif > max) {
                    max = dif;
                }
            }
        }
        return (int) max;
    }
}