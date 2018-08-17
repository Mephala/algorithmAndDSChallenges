package com.gokhanozg.codility.floodDepth;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        int n = A.length;
        if (n < 3) {
            return 0;
        }
        int[] lr = new int[n];
        int[] rl = new int[n];
        int lrMax = Integer.MIN_VALUE;
        int rlMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            lrMax = Math.max(lrMax, A[i]);
            rlMax = Math.max(rlMax, A[n - 1 - i]);
            lr[i] = lrMax;
            rl[n - 1 - i] = rlMax;
        }
        int maxDepth = 0;
        for (int i = 1; i < n - 1; i++) {
            maxDepth = Math.max(maxDepth, Math.min(lr[i - 1], rl[i + 1]) - A[i]);
        }
        return maxDepth;
    }
}