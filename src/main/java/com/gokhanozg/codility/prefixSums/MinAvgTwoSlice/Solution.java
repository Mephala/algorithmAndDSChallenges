
package com.gokhanozg.codility.prefixSums.MinAvgTwoSlice;

class Solution {
    public int solution(int[] A) {

        long[] sums = new long[A.length];
        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                sums[i] = A[i];
            } else {
                sums[i] = sums[i - 1] + A[i];
            }
        }
        double minAvg = Double.MAX_VALUE;
        int minIndice = -1;
        for (int sliceLen = 2; sliceLen <= 3; sliceLen++) {
            for (int i = 0; i < A.length - sliceLen + 1; i++) {
                long sum;
                if (i == 0) {
                    sum = sums[i + sliceLen - 1];
                } else {
                    sum = sums[i + sliceLen - 1] - sums[i - 1];
                }
                double avg = (double) sum / sliceLen;
                if (avg < minAvg) {
                    minIndice = i;
                    minAvg = avg;
                }
            }
        }
        return minIndice;
    }
}