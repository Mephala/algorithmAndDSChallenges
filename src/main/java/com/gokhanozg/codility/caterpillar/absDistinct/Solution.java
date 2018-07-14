package com.gokhanozg.codility.caterpillar.absDistinct;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (Integer integer : A) {
            set.add(Math.abs(integer));
        }
        return set.size();
    }
}