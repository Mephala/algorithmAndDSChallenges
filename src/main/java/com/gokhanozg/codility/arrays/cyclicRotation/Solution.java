package com.gokhanozg.codility.arrays.cyclicRotation;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        if (A.length == 0) {
            return A;
        }
        for (int i = 0; i < K; i++) {
            rotateArray(A);
        }
        return A;
    }

    private void rotateArray(int[] a) {
        int mem = a[a.length - 1];
        for (int i = 0; i < a.length; i++) {
            int tmp = a[i];
            a[i] = mem;
            mem = tmp;
        }
    }
}