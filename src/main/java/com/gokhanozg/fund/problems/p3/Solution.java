package com.gokhanozg.fund.problems.p3;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A, int[] B, int[] C) {
        //sort and binary search instead?
        int n = B.length;
        long total = 0L;
        for (int i = 0; i < n; i++) {
            int val = B[i];
            int smallerCount = 0;
            for (int j = 0; j < n; j++) {
                if (A[j] < val) {
                    smallerCount++;
                }
            }
            int largerCount = 0;
            for (int j = 0; j < C.length; j++) {
                if (C[j] > val) {
                    largerCount++;
                }
            }
            total += (smallerCount * largerCount);
            if (total > 1E9) {
                return -1;
            }
        }
        return (int) total;
    }

}