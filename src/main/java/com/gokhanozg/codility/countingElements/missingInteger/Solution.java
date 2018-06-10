package com.gokhanozg.codility.countingElements.missingInteger;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> values = new HashSet<>();
        for (int i : A) {
            values.add(i);
        }
        for (int i = 1; i <= 100000; i++) {
            if (!values.contains(i))
                return i;
        }
        return -1;
    }
}