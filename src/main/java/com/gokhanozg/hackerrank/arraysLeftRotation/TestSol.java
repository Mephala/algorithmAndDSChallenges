package com.gokhanozg.hackerrank.arraysLeftRotation;

/**
 * Created by Gokhan Ozgozen on 27-Jul-18.
 */
public class TestSol {

    public static void main(String[] args) {
        System.out.println(arrayprint(Solution.rotLeft(new int[]{1, 2, 3, 4, 5}, 4)));
        System.out.println(arrayprint(Solution.rotLeft(new int[]{1}, 4)));
        System.out.println(arrayprint(Solution.rotLeft(new int[]{1, 2, 3, 4, 5}, 5)));
    }

    private static String arrayprint(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + ", ");
        }
        String rv = sb.toString();
        return rv.substring(0, rv.length() - 2);
    }
}
