package com.gokhanozg.codility.maxSliceProblem.base;

/**
 * Created by Gokhan Ozgozen on 7/5/18.
 */
public class Tutorial {

    public static void main(String[] args) {
        System.out.println(getMaxSlice(new int[]{5, -7, 3, 5, -2, 4, -1}));

    }

    private static long getMaxSlice(int[] arr) {
        long maxEnding = 0L;
        long maxSlice = 0L;
        for (int i : arr) {
            maxEnding = Math.max(0, maxEnding + i);
            maxSlice = Math.max(maxSlice, maxEnding);
        }
        return maxSlice;
    }
}
