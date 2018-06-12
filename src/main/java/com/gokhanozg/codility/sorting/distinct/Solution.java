package com.gokhanozg.codility.sorting.distinct;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A == null || A.length == 0)
            return 0;
        Set<Integer> values = new HashSet<>();
        for (Integer value : A) {
            values.add(value);
        }
        return values.size();

    }
}