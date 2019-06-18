package com.gokhanozg.hackerrank.fraudulentActivityNotifications;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Gokhan Ozgozen on 18-Jun-19.
 */
public class Test {
    public static void main(String[] args) {
        final int lim = 3000000;
        Random r = new Random();
        List<Integer> vals = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lim; i++) {
            int val = r.nextInt(10);
            vals.add(r.nextInt(10));
            max = Math.max(max, val);
            min = Math.min(min, val);
        }

        System.err.println(max);
        System.err.println(min);
        long t1 = System.nanoTime();
        int[] counts = new int[10];
        for (Integer val : vals) {
            counts[val] = counts[val] + 1;
        }

        for (int i = 1; i < counts.length; i++) {
            counts[i] = counts[i - 1] + counts[i];
        }

        int[] sorted = new int[lim];

        for (int i = lim - 1; i >= 0; i--) {
            sorted[counts[vals.get(i)] - 1] = vals.get(i);
            counts[vals.get(i)]--;
        }
        long t2 = System.nanoTime();

        Collections.sort(vals);

        long t3 = System.nanoTime();

        List<Integer> countSorted = new ArrayList<>();
        for (int i : sorted) {
            countSorted.add(i);
        }

        System.err.println(String.format("Count sort in %s millis, normal sort in %s millis, results are equal:%s",
                TimeUnit.NANOSECONDS.toMillis(t2 - t1), TimeUnit.NANOSECONDS.toMillis(t3 - t2),
                CollectionUtils.isEqualCollection(countSorted, vals)));


    }
}
