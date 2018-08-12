package com.gokhanozg.codility.dynamicProgramming.minAbs;

import java.util.HashMap;
import java.util.Map;

class Solution {
    //Fails on one case, achieves almost full score. Don't know yet why it fails. I will update once I have my curiosity
    // is back on this : )

    public int solution(int[] A) {
        int sum = 0;
        int max = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int val = Math.abs(A[i]);
            sum += val;
            A[i] = val;
            max = Math.max(val, max);
            countMap.put(val, countMap.getOrDefault(val, 0) + 1);
        }
        int[] dp = new int[sum + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = -1;
        }
        int[] count = new int[max + 1];
        for (Map.Entry<Integer, Integer> countMapEntry : countMap.entrySet()) {
            count[countMapEntry.getKey()] = countMapEntry.getValue();
        }
        for (int i = 1; i < max + 1; i++) {
            if (count[i] > 0) {
                for (int j = 0; j < dp.length; j++) {
                    if (dp[j] >= 0) {
                        dp[j] = count[i];
                    } else if (j >= i && dp[j - i] > 0) {
                        dp[j] = dp[j - i] - 1;
                    }
                }
            }
        }
        int half = sum / 2;
        for (int i = half; i >= 0; i--) {
            if (dp[i] >= 0) {
                return Math.abs((sum - i) - i);
            }
        }
        return -1;
    }
//    public int solution(int[] A) {
//        int sum = 0;
//        for (int i = 0; i <A.length ; i++) {
//            sum += Math.abs(A[i]);
//            A[i] = Math.abs(A[i]);
//        }
//        int half = sum / 2;
//        int[] sums = new int[sum + 1];
//        sums[0] = 1;
//        for (int a : A) {
//            for (int i = sums.length -1; i >=0 ; i--) {
//                if(sums[i] == 1 && (i+a)<=sum){
//                    sums[i+a] = 1;
//                }
//            }
//        }
//        for (int i = half; i >= 0; i--) {
//            if (sums[i] == 1) {
//                return Math.abs((sum - i) - i);
//            }
//        }
//        return -1;
//    }


}