package com.gokhanozg.misc.prknv;

import java.util.Arrays;

/**
 * Created by Gokhan Ozgozen on 08-Nov-18.
 */
public class Solution {

    private static final boolean DEBUG = false; // if true, prints where to put cameras.

    // I have added bunch of test cases, including the ones provided in the document. I am also testing performance of both
    // variants in the bottom.

    public static void main(String[] args) {
        System.out.println("expected:2, " + findMinimumNumberOfCameras(1, new int[]{1, 2, 3, 4, 5}));
        System.out.println("expected:1, " + findMinimumNumberOfCameras(1, new int[]{1}));
        System.out.println("expected:1, " + findMinimumNumberOfCameras(1, new int[]{1, 2}));
        System.out.println("expected:2, " + findMinimumNumberOfCameras(1, new int[]{2, 4}));
        System.out.println("expected:1, " + findMinimumNumberOfCameras(1, new int[]{2}));
        System.out.println("expected:1, " + findMinimumNumberOfCameras(1, new int[]{10}));
        System.out.println("expected:1, " + findMinimumNumberOfCameras(5, new int[]{1, 6, 11}));
        System.out.println("expected:3, " + findMinimumNumberOfCameras(2, new int[]{2, 4, 5, 6, 7, 9, 11, 12}));
        System.out.println("expected:3, " + findMinimumNumberOfCameras(10, new int[]{1, 15, 30, 40, 50}));
        System.out.println("expected:5, " + findMinimumNumberOfCameras(1, new int[]{1, 3, 5, 7, 9}));
        System.out.println("expected:1, " + findMinimumNumberOfCameras(10, new int[]{1, 3, 5, 7, 9}));
        System.out.println("expected:1, " + findMinimumNumberOfCameras(1, new int[]{1, 2, 3}));
        System.out.println("expected:3, " + findMinimumNumberOfCameras(2, new int[]{4, 5, 6, 7, 8, 9, 12}));
        System.out.println("expected:6, " + findMinimumNumberOfCameras(10, new int[]{1, 2, 3, 4, 5, 6, 11, 21, 31, 41, 51, 61, 72, 83, 94}));
        System.out.println("expected:11, " + findMinimumNumberOfCameras(2, new int[]{1, 2, 3, 4, 5, 6, 11, 21, 31, 41, 51, 61, 72, 83, 94}));
        int[] largeInt = new int[(int) 1E7];
        for (int i = 1; i <= 1E7; i++) {
            largeInt[i - 1] = i;
        }
        long start = System.nanoTime();
        System.out.println(findMinimumNumberOfCameras(1, largeInt));
        long normalEnd = System.nanoTime() - start;
        start = System.nanoTime();
        System.out.println(findMinimumNumberOfCamerasBS(1, largeInt));
        long bsEnd = System.nanoTime() - start;
        System.out.println("Normal execution:" + normalEnd + " , bsExecution:" + bsEnd);

    }


    private static int findNextLowestUncoveredSpotIndex(int cameraRange, int lowestUncoveredSpotIndex, int[] parkingSpaces) {
        // this is the optimal spot to place camera, if it exists in the array.
        int optimalSpot = parkingSpaces[lowestUncoveredSpotIndex] + cameraRange;

        // this is the optimal index, that may contain sub-optimal camera placement spot.
        int optimalSpotIndex = Math.min(lowestUncoveredSpotIndex + cameraRange, parkingSpaces.length - 1);

        // decrementing optimal spot index, in case it is not available.
        while (parkingSpaces[optimalSpotIndex] > optimalSpot) {
            optimalSpotIndex--;
        }
        if (DEBUG) {
            System.out.println("Placing camera on spot:" + parkingSpaces[optimalSpotIndex]);
        }
        // we now have sub optimal spot to place camera. Calculating its radius to both directions.
        int highestCoverageSpot = parkingSpaces[optimalSpotIndex] + cameraRange;
        int highestCoverageSpotIndex = Math.min(optimalSpotIndex + cameraRange, parkingSpaces.length - 1);
        // finding the highest possible array index that is covered, we will increment it 1 and return afterwards.
        while (parkingSpaces[highestCoverageSpotIndex] > highestCoverageSpot) {
            highestCoverageSpotIndex--;
        }
        return highestCoverageSpotIndex + 1; // next index is the lowest uncovered index.
    }


    /**
     * The algorithm is a variant of greedy-algorithms. For every uncovered parking spot index in the array, it picks the
     * optimal spot for the next camera placement. ( parking spot + camera range ). If the spot is available in the given array,
     * it marks this spot for next placement and then calculates its coverage  in both directions. Afterwards, applies the same
     * greedy approach to next lowest uncovered parking spot until all of the spots are covered.
     * <p>
     * Since the parking spot numbers are sorted, my first intention was to apply binary sort to check existence of the next
     * optimal spot. However, we already know the maximum range and current spot, we can simply check if the array[optimalSpot+range]
     * value is suitable or not, which is more efficient performance-wise.
     * <p>
     * In any case, I am sending my initial draft of the code which uses binary search, along with my test cases so you can see
     * counting-search is more efficient for large inputs (1E7 ).
     * <p>
     * Final algorithm runs O(n) in time complexity and O(n) in space complexity at worst-case scenario, including given parkingSpaces[n] array.
     * Worst case scenario for binary search variant is O(nlogn).
     */
    static int findMinimumNumberOfCameras(int cameraRange, int[] parkingSpaces) {
        // initially parkingSpaces[0] lowest possible uncovered index.
        int lowestUncoveredSpotIndex = 0;
        int totalCamerasNeeded = 0;

        // we are making sure all parkingSpaceIndexes are covered by cameras.
        while (lowestUncoveredSpotIndex <= parkingSpaces.length - 1) {
            // calculates and return next uncovered minimum spot, greedy approach for finding next sub-optimal.
            lowestUncoveredSpotIndex = findNextLowestUncoveredSpotIndex(cameraRange, lowestUncoveredSpotIndex, parkingSpaces);
            // at each iteration, it places 1 camera to cover-up as much spots as possible.
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
