package com.gokhanozg.codility.countingElements.permCheck;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        Set<Integer> values = new HashSet<>();
        for (int i : A) {
            if (values.contains(i))
                return 0; //duplicate item.
            values.add(i);
        }
        for (int i = 1; i <= N; i++) {
            if (!values.contains(i))
                return 0;
        }
        return 1;
    }
}