
package com.gokhanozg.codility.prefixSums.MinAvgTwoSlice;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] A) {

        int[] sums = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                sums[i] = A[i];
            } else {
                sums[i] = sums[i - 1] + A[i];
            }
        }
        Map<Double, Integer> averageIndexMap = new HashMap<>();
        double minAvg = Double.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int elements = j - i + 1;
                int sum;
                if (j - elements == -1) {
                    sum = sums[j];
                } else {
                    sum = sums[j] - sums[j - elements];
                }
                double avg = ((double) sum) / elements;
                if (!averageIndexMap.containsKey(avg) || i < averageIndexMap.get(avg))
                    averageIndexMap.put(avg, i);
                if (avg < minAvg)
                    minAvg = avg;
            }
        }
        return averageIndexMap.get(minAvg);
    }
}