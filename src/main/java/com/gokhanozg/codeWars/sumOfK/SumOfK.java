package com.gokhanozg.codeWars.sumOfK;

import java.util.Arrays;
import java.util.List;

public class SumOfK {

    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
        int[] d = ls.stream().mapToInt(i -> i).toArray();
        Arrays.sort(d);
        long sum = -1;
        for (int i = 0; i < d.length - k; i++) {
            long tmp = d[i];
            for (int j = i + 1; j < i + k; j++) {
                tmp += d[j];
                if (tmp >= t) {
                    return sum == -1 ? null : (int) sum;
                }
            }
            sum = tmp;
        }
        return null;
    }
}
