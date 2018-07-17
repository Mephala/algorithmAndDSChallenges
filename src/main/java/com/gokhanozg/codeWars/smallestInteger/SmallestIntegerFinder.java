package com.gokhanozg.codeWars.smallestInteger;

public class SmallestIntegerFinder {
    public static int findSmallestInt(int[] args) {
        int lowest = Integer.MAX_VALUE;
        for (int arg : args) {
            lowest = Math.min(arg, lowest);
        }
        return lowest;

    }
}