package com.gokhanozg.fund.problems.p1;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] A, int[] B) {
        int[] opt = new int[A.length];
        Set<Integer> shownNums = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            opt[i] = Math.max(A[i], B[i]);
            shownNums.add(opt[i]);
        }
        for (int i = 1; i <= 100001; i++) {
            if (!shownNums.contains(i))
                return i;
        }
        return -1;
    }
}