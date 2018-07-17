package com.gokhanozg.codility.dynamicProgramming.numberSolitaire;

import java.util.Arrays;


class Solution {
    public int solution(int[] A) {
        long[] bestResults = new long[A.length];
        Arrays.fill(bestResults, Long.MIN_VALUE);
        bestResults[0] = A[0]; // Fixed.
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length && j < i + 7; j++) {
                long previousBest = bestResults[j];
                bestResults[j] = Math.max(previousBest, bestResults[i] + A[j]);
            }
        }
        return (int) bestResults[A.length - 1];
    }


    public int solution2(int A[]) {
        // N //  N is an integer within the range [2..100,000];
        // A[] // each element of array A is an integer within the range [−10,000..10,000].
        int N = A.length;
        int[] bestResult = new int[N]; // record the current bestResult
        Arrays.fill(bestResult, Integer.MIN_VALUE); // fill in with the smallest integer value

        // initialize
        bestResult[0] = A[0];
        for (int i = 0; i < A.length; i++) {
            // calculate six possible results every round
            for (int j = i + 1; (j < A.length) && (i < A.length) && j < (i + 1) + 6; j++) {
                // compare
                int preMaxResult = bestResult[j]; // the max number so far
                int nowMaxResult = bestResult[i] + A[j]; // the max number at bestResult[i] + A[j]
                bestResult[j] = Math.max(preMaxResult, nowMaxResult);
            }
        }
        return bestResult[bestResult.length - 1];
    }
}


//    public int solution(int[] A) {
//        int[] store = new int[A.length];
//        store[0] = A[0];
//        for (int i = 1; i < A.length; i++) {
//            store[i] = store[i-1];
//            for (int minus = 2; minus <= 6; minus++) {
//                if (i >= minus) {
//                    store[i] = Math.max(store[i], store[i - minus]);
//                } else {
//                    break;
//                }
//            }
//            store[i] += A[i];
//        }
//        return store[A.length - 1];
//    }




