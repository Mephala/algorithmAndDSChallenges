package com.gokhanozg.fund.binarySearch;

import java.util.*;


/**
 * Created by Gokhan Ozgozen on 13-Jul-18.
 */
public class TestImp {

    // binary Search

    public static void main(String[] args) {
        final int len = 100000;
        int arr[] = new int[len];
        List<Integer> randomElements = new ArrayList<>();
        Random r = new Random();
        HashSet<Integer> set = new HashSet<>(); //ensure we have distinct values.
        for (int i = 0; i < len; i++) {
            int next = r.nextInt();
            while (set.contains(next)) {
                next = r.nextInt();
            }
            set.add(next);
            randomElements.add(next);
            arr[i] = next;
        }
        Collections.sort(randomElements);
        Arrays.sort(arr); // prereq for binary Search.
        for (int i = 0; i < len; i++) {
            int searchIndex = r.nextInt(len);
            int value = randomElements.get(searchIndex);
            int index = manualBinarySearch(arr, value);
            int javaIndex = Arrays.binarySearch(arr, value);
            if (javaIndex != index) {
                System.err.println("Failed implementation");
            }
            if (index != searchIndex) {
                System.err.println("Failed manual index finding");
            }
        }
        System.out.println("Done.");
    }

    public static int manualBinarySearch(int[] arr, Integer val) {
        int begin = 0;
        int end = arr.length - 1;
        int result = -1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (arr[mid] == val) {
                result = mid;
                break;
            } else if (arr[mid] < val) {
                begin = mid + 1;
            } else {
                //mid > val
                end = mid - 1;
            }
        }
        return result;
    }


}
