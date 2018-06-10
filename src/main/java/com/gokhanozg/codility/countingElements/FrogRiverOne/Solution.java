package com.gokhanozg.codility.countingElements.FrogRiverOne;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int X, int[] A) {
        // write your code in Java SE 8
        Set<Integer> leaveCoords = new HashSet<>();
        for (int i = 1; i <= X; i++) {
            leaveCoords.add(i);
        }
        for (int i = 0; i < A.length; i++) {
            leaveCoords.remove(A[i]);
            if (leaveCoords.size() == 0) {
                return i;
            }
        }
        return -1;
    }
}