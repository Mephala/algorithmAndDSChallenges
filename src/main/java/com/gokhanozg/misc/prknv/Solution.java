package com.gokhanozg.misc.prknv;

import java.util.Arrays;

/**
 * Created by Gokhan Ozgozen on 08-Nov-18.
 */
public class Solution {

    private static final boolean DEBUG = false; // if true, prints where to put cameras.

//    public static void main(String[] args) {
//        System.out.println("expected:2, " + findMinimumNumberOfCameras(1, new int[]{1, 2, 3, 4, 5}));
//        System.out.println("expected:1, " + findMinimumNumberOfCameras(1, new int[]{1}));
//        System.out.println("expected:1, " + findMinimumNumberOfCameras(1, new int[]{1,2}));
//        System.out.println("expected:2, " + findMinimumNumberOfCameras(1, new int[]{2,4}));
//        System.out.println("expected:1, " + findMinimumNumberOfCameras(1, new int[]{2}));
//        System.out.println("expected:1, " + findMinimumNumberOfCameras(1, new int[]{10}));
//        System.out.println("expected:1, " + findMinimumNumberOfCameras(5, new int[]{1,6,11}));
//        System.out.println("expected:3, " + findMinimumNumberOfCameras(2, new int[]{2, 4, 5, 6, 7, 9, 11, 12}));
//        System.out.println("expected:3, " + findMinimumNumberOfCameras(10, new int[]{1, 15, 30, 40, 50}));
//        System.out.println("expected:5, " + findMinimumNumberOfCameras(1, new int[]{1, 3, 5, 7, 9}));
//        System.out.println("expected:1, " + findMinimumNumberOfCameras(10, new int[]{1, 3, 5, 7, 9}));
//        System.out.println("expected:1, " + findMinimumNumberOfCameras(1, new int[]{1, 2, 3}));
//        System.out.println("expected:3, " + findMinimumNumberOfCameras(2, new int[]{4, 5, 6, 7, 8, 9, 12}));
//        System.out.println("expected:6, " + findMinimumNumberOfCameras(10, new int[]{1, 2, 3, 4, 5, 6, 11, 21, 31, 41, 51, 61, 72, 83, 94}));
//        System.out.println("expected:11, " + findMinimumNumberOfCameras(2, new int[]{1, 2, 3, 4, 5, 6, 11, 21, 31, 41, 51, 61, 72, 83, 94}));
//        int[] largeInt = new int[(int) 1E7];
//        for (int i = 1; i <= 1E7; i++) {
//            largeInt[i - 1] = i;
//        }
//        long start = System.nanoTime();
//        System.out.println(findMinimumNumberOfCameras(1, largeInt));
//        long normalEnd = System.nanoTime() -start;
//        start = System.nanoTime();
//        System.out.println(findMinimumNumberOfCamerasBS(1, largeInt));
//        long bsEnd = System.nanoTime() - start;
//        System.out.println("Normal execution:" + normalEnd + " , bsExecution:"+ bsEnd);
//
//    }


    private static int findNextLowestUncoveredSpotIndex(int cameraRange, int lowestUncoveredSpotIndex, int[] parkingSpaces) {
        int optimalSpot = parkingSpaces[lowestUncoveredSpotIndex] + cameraRange;
        int optimalSpotIndex = Math.min(lowestUncoveredSpotIndex + cameraRange, parkingSpaces.length - 1);
        while (parkingSpaces[optimalSpotIndex] > optimalSpot) {
            optimalSpotIndex--;
        }
        if (DEBUG) {
            System.out.println("Placing camera on spot:" + parkingSpaces[optimalSpotIndex]);
        }
        // we now have sub optimal spot to place camera. Calculating its radius to both directions.
        int highestCoverageSpot = parkingSpaces[optimalSpotIndex] + cameraRange;
        int highestCoverageSpotIndex = Math.min(optimalSpotIndex + cameraRange, parkingSpaces.length - 1);
        while (parkingSpaces[highestCoverageSpotIndex] > highestCoverageSpot) {
            highestCoverageSpotIndex--;
        }
        return highestCoverageSpotIndex + 1; // next index is the lowest uncovered index.
    }


    static int findMinimumNumberOfCameras(int cameraRange, int[] parkingSpaces) {
        int lowestUncoveredSpotIndex = 0;
        int totalCamerasNeeded = 0;
        while (lowestUncoveredSpotIndex <= parkingSpaces.length - 1) {
            lowestUncoveredSpotIndex = findNextLowestUncoveredSpotIndex(cameraRange, lowestUncoveredSpotIndex, parkingSpaces);
            totalCamerasNeeded++;
        }
        return totalCamerasNeeded;
    }


    private static int findMinimumNumberOfCamerasBS(int cameraRange, int[] parkingSpaces) {
        int lowestUncoveredSpotIndex = 0;
        int totalCamerasNeeded = 0;
        while (lowestUncoveredSpotIndex <= parkingSpaces.length - 1) {
            lowestUncoveredSpotIndex = findNextLowestUncoveredSpotIndexBinarySearch(cameraRange, lowestUncoveredSpotIndex, parkingSpaces);
            totalCamerasNeeded++;
        }
        return totalCamerasNeeded;
    }

    private static int findNextLowestUncoveredSpotIndexBinarySearch(int cameraRange, int lowestUncoveredSpotIndex, int[] parkingSpaces) {
        int optimalSpot = parkingSpaces[lowestUncoveredSpotIndex] + cameraRange;
        int optimalSpotIndex = Arrays.binarySearch(parkingSpaces, optimalSpot);
        while (optimalSpotIndex < 0) {
            optimalSpot--;
            optimalSpotIndex = Arrays.binarySearch(parkingSpaces, optimalSpot);
        }
        // we now have sub optimal spot to place camera. Calculating its radius to both directions.
        if (DEBUG) {
            System.out.println("Placing camera on spot:" + parkingSpaces[optimalSpotIndex]);
        }
        int highestCoverageSpot = parkingSpaces[optimalSpotIndex] + cameraRange;
        int highestCoverageSpotIndex = Arrays.binarySearch(parkingSpaces, highestCoverageSpot);
        while (highestCoverageSpotIndex < 0) {
            highestCoverageSpot--;
            highestCoverageSpotIndex = Arrays.binarySearch(parkingSpaces, highestCoverageSpot);
        }
        return highestCoverageSpotIndex + 1; // next index is the lowest uncovered index.
    }


}
