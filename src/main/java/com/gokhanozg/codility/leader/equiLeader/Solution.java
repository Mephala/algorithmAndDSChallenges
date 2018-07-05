package com.gokhanozg.codility.leader.equiLeader;

import java.util.HashMap;
import java.util.Map;

class Solution {


    public int solution(int[] A) {

        int maxOccurrence = 0;
        int maxOccuredValue = 0;
        Map<Integer, Integer> valueOccurenceMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            valueOccurenceMap.put(A[i], valueOccurenceMap.getOrDefault(A[i], 0) + 1);
            if (valueOccurenceMap.get(A[i]) > maxOccurrence) {
                maxOccurrence = valueOccurenceMap.get(A[i]);
                maxOccuredValue = A[i];
            }
        }
        int[] occurenceArray = new int[A.length];
        int occurenceCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == maxOccuredValue) {
                occurenceCount++;
                occurenceArray[i] = occurenceCount;
            } else {
                occurenceArray[i] = 0;
            }
        }
        int equiCount = 0;
        int occurenceSoFar = 0;
        for (int i = 0; i < occurenceArray.length; i++) {
            if (occurenceArray[i] == 0) {
                int split1 = i + 1;
                int split2 = occurenceArray.length - (i + 1);
                if (occurenceSoFar > split1 / 2 && maxOccurrence - occurenceSoFar > split2 / 2) {
                    equiCount++;
                }
            } else {
                occurenceSoFar++;
                int split1 = i + 1;
                int split2 = A.length - (i + 1);
                if (occurenceSoFar > split1 / 2 && maxOccurrence - occurenceSoFar > split2 / 2) {
                    equiCount++;
                }
            }
        }
        return equiCount;

    }
}