package com.gokhanozg.hackerrank.maxArraySum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mephalay on 21-Jul-18.
 */
public class TestSol {

    public static void main(String[] args) {
        System.out.println("11," + Solution.maxSubsetSum(new int[]{2, 1, 5, 8, 4}));
        System.out.println("11," + Solution.maxSubsetSum(new int[]{4, 8, 6, 3}));
        System.out.println("80," + Solution.maxSubsetSum(new int[]{20, 1, 30, 60, 10}));
        System.out.println("8," + Solution.maxSubsetSum(new int[]{-2, 1, 3, -4, 5}));
        System.out.println("13," + Solution.maxSubsetSum(new int[]{3, 7, 4, 6, 5}));
        System.out.println("11," + Solution.maxSubsetSum(new int[]{2, 1, 5, 8, 4}));
        System.out.println("15," + Solution.maxSubsetSum(new int[]{3, 5, -7, 8, 10}));
        System.out.println("-90," + Solution.maxSubsetSum(new int[]{-90, -90, -90, -90, -90}));
        System.out.println("-90," + Solution.maxSubsetSum(new int[]{-90}));
        System.out.println("8," + Solution.maxSubsetSum(new int[]{8}));
        System.out.println("12," + Solution.maxSubsetSum(new int[]{2, -2, -10, -1, -1, -8, 10, 9}));
        System.out.println("12," + Solution.maxSubsetSum(new int[]{2, -2, -10, -1, -1, -8, 10, 9}));
        System.out.println("10," + Solution.maxSubsetSum(new int[]{4, -1, 5, 6}));
        System.out.println("80," + Solution.maxSubsetSum(new int[]{1, 20, 30, 60, 10}));
        System.out.println("90," + Solution.maxSubsetSum(new int[]{1, 30, 20, 60, 10}));
        System.out.println("3," + Solution.maxSubsetSum(new int[]{1, 1, 1, 1, 1}));
        System.out.println("3," + Solution.maxSubsetSum(new int[]{1, 1, 1, 1, 1}));
        System.out.println("12," + Solution.maxSubsetSum(new int[]{-2, -3, 4, 10, 7, -2, -4, 1}));

    }
}
