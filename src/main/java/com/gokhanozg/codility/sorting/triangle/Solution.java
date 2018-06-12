package com.gokhanozg.codility.sorting.triangle;

import java.util.*;

class Solution {
    public int solution(int[] A) {
        if (A == null || A.length < 3)
            return 0;
        // write your code in Java SE 8
        List<Integer> posValues = new ArrayList<>();
        for (int i : A) {
            if (i > 0) {
                posValues.add(i);
            }
        }
        Collections.sort(posValues);
        return searchTriangle(posValues);
    }

    private int searchTriangle(List<Integer> posValues) {
        if (posValues.size() >= 3) {
            for (int i = 1; i < posValues.size() - 1; i++) {
                long lowest = posValues.get(i - 1);
                long mid = posValues.get(i);
                long high = posValues.get(i + 1);
                boolean validTriange = lowest + mid > high && lowest + high > mid && high + mid > lowest;
                if (validTriange)
                    return 1;
            }
            return 0;
        } else {
            return 0;
        }
    }
}