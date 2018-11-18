package com.gokhanozg.codility.emerald.sol2;

/**
 * Created by Gokhan Ozgozen on 18-Nov-18.
 */
public class TestSol {

    public static void main(String[] args) {
        int[] arr = new Solution().solution(10);
        printArr(arr);
        System.out.println("Correct:" + corrMin(arr) + " , fail:" + find_min(arr));
        System.out.println("*******");
        arr = new Solution().solution(1);
        printArr(arr);
        System.out.println("Correct:" + corrMin(arr) + " , fail:" + find_min(arr));
        System.out.println("*******");
        arr = new Solution().solution(2);
        printArr(arr);
        System.out.println("Correct:" + corrMin(arr) + " , fail:" + find_min(arr));
        System.out.println("*******");
        arr = new Solution().solution(1000);
        printArr(arr);
        System.out.println("Correct:" + corrMin(arr) + " , fail:" + find_min(arr));
        System.out.println("*******");
    }

    private static int find_min(int[] A) {
        int ans = 0;
        for (int i = 1; i < A.length; i++) {
            if (ans > A[i]) {
                ans = A[i];
            }
        }
        return ans;
    }

    private static int corrMin(int[] A) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            min = Math.min(min, A[i]);
        }
        return min;
    }

    static void printArr(int[] arr) {
        System.out.println();
        for (int i : arr) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
