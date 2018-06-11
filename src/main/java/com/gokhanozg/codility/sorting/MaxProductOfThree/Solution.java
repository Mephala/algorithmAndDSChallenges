package com.gokhanozg.codility.sorting.MaxProductOfThree;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        if (A.length == 3) {
            return A[0] * A[1] * A[2];
        }
        for (int i : A) {
            maxHeap.add(i);
            minHeap.add(i);
        }
        int[] top3 = {maxHeap.poll(), maxHeap.poll(), maxHeap.poll()};
        int[] min3 = {minHeap.poll(), minHeap.poll()};

        int can1 = top3[0] * top3[1] * top3[2];
        int can2 = top3[0] * min3[0] * min3[1];

        return Math.max(can1, can2);

    }
}