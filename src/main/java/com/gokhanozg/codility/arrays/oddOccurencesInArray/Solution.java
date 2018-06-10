package com.gokhanozg.codility.arrays.oddOccurencesInArray;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();

        for (int i : A) {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }
        if (set.size() == 0) {
            System.out.println("Error, set is empty");
        } else {
            for (Integer integer : set) {
                return integer;
            }
        }
        return -1;

    }
}