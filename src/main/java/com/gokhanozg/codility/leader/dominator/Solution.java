package com.gokhanozg.codility.leader.dominator;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] A) {
        int occurence = 0;
        Map<Integer, Integer> valueOccurenceMap = new HashMap<>();
        int maxOccurenceIndex = -1;
        for (int i = 0; i < A.length; i++) {
            valueOccurenceMap.put(A[i], valueOccurenceMap.getOrDefault(A[i], 0) + 1);
            if (valueOccurenceMap.get(A[i]) > occurence) {
                maxOccurenceIndex = i;
                occurence = valueOccurenceMap.get(A[i]);
            }
        }
        return maxOccurenceIndex == -1 ? maxOccurenceIndex : occurence > A.length / 2 ? maxOccurenceIndex : -1;
    }
}