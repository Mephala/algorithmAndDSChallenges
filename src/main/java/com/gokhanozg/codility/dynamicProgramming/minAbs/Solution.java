package com.gokhanozg.codility.dynamicProgramming.minAbs;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    //Fails on one case, achieves almost full score. Don't know yet why it fails. I will update once I have my curiosity
    // is back on this : )

    public int solution(int[] A) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        long sum1 = 0L;
        long sum2 = 0L;
        for (int i = 0; i < A.length; i++) {
            maxHeap.add(Math.abs(A[i]));
            sum1 += Math.abs(A[i]);
        }
        if (maxHeap.size() == 0) {
            return 0;
        }
        long dif = sum1 - sum2;
        while (dif >= (maxHeap.peek() * 2)) {
            if (maxHeap.size() != 0) {
                long val = maxHeap.poll();
                sum1 -= val;
                sum2 += val;
                dif = sum1 - sum2;
                dif = Math.abs(dif);
                if (maxHeap.size() == 0) {
                    break;
                }
            }
        }
        while (maxHeap.size() > 0) {
            long val = maxHeap.poll();
            if (dif >= val * 2) {
                dif -= val * 2;
            }
        }
        return (int) dif;
    }


}