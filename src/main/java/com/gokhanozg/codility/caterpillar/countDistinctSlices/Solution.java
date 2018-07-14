package com.gokhanozg.codility.caterpillar.countDistinctSlices;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Long> valCache = new HashMap<>();

    public int solution(int M, int[] A) {
        Map<Integer, Integer> valueToPositionMap = new HashMap<>();
        long total = 0L;
        for (int i = 0; i < A.length; i++) {
            if (valueToPositionMap.containsKey(A[i])) {
                total += calcSum(valueToPositionMap.size());
                if (total > 1E9)
                    return (int) 1E9;
                total += (i - valueToPositionMap.get(A[i])) - 1;
                valueToPositionMap.clear();
            }
            valueToPositionMap.put(A[i], i);
        }
        if (valueToPositionMap.size() > 0) {
            total += calcSum(valueToPositionMap.size());
        }
        if (total > 1E9) {
            return (int) 1E9;
        }
        return (int) total;
    }

    private long calcSum(int val) {
        if (valCache.containsKey(val)) {
            return valCache.get(val);
        }
        long total = 0;
        for (int i = 1; i <= val; i++) {
            total += (val - i) + 1;
        }
        valCache.put(val, total);
        return total;
    }
}