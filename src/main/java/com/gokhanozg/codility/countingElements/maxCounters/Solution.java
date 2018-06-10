package com.gokhanozg.codility.countingElements.maxCounters;

class Solution {
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int[] retval = new int[N];
        int maxCounter = 0;
        int minLimit = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 1 && A[i] <= N) {
                //increase op
                int newcounter = retval[A[i] - 1];
                if (newcounter < minLimit) {
                    newcounter = minLimit;
                }
                newcounter++;
                if (newcounter > maxCounter) {
                    maxCounter = newcounter;
                }
                retval[A[i] - 1] = newcounter;
            } else if (A[i] == N + 1) {
                minLimit = maxCounter;
            } else {
                System.out.println("Unsupported operation! N:" + N + ", index:" + i + ", operation:" + A[i]);
            }
        }
        for (int i = 0; i < N; i++) {
            if (retval[i] < minLimit)
                retval[i] = minLimit;
        }
        return retval;

    }
}