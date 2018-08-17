package com.gokhanozg.fund.longestIncreasingSubseq;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");


class Solution {

    public int solution(int[] A) {
        int[] dp = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int max = 1;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;

    }


}