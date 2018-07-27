package com.gokhanozg.hackerrank.candies;

import java.util.Random;

/**
 * Created by Gokhan Ozgozen on 27-Jul-18.
 */
public class TestSol {

    public static void main(String[] args) {

//        System.out.println("10," + Solution.candies(6,new int[]{1,2,1,2,3,1}));
//        System.out.println("4," + Solution.candies(3,new int[]{1,2,2}));
//        System.out.println("19," + Solution.candies(10,new int[]{2,4,2,6,1,7,8,9,2,1}));
//        System.out.println("12," + Solution.candies(8, new int[]{2, 4, 3, 5, 2, 6, 4, 5}));
//        System.out.println("9," + Solution.candies(5,new int[]{2,1,6,4,2}));
//        System.out.println("15," + Solution.candies(5,new int[]{1,2,3,4,5}));
//        System.out.println("15," + Solution.candies(5,new int[]{5,4,3,2,1}));
//        System.out.println("36," + Solution.candies(11,new int[]{1,2,3,4,5,100,99,98,97,96,95}));
//        System.out.println("6," + Solution.candies(6,new int[]{1,1,1,1,1,1}));
//        System.out.println("7," + Solution.candies(6,new int[]{1,1,1,1,2,1}));
//        System.out.println("31," + Solution.candies(10,new int[]{3,6,9,12,15,14,13,12,11,10}));
//        System.out.println("68," + Solution.candies(20,new int[]{3,6,9,12,15,14,13,12,11,10,3,6,9,12,15,14,13,12,11,10}));
//        System.out.println("11," + Solution.candies(5,new int[]{1,20,4,3,2}));
//        System.out.println("26," + Solution.candies(10,new int[]{1,20,4,3,2,1,20,4,3,2}));
//        System.out.println("18," + Solution.candies(7,new int[]{200,100,600,4,3,2,1}));
//        System.out.println("36," + Solution.candies(14,new int[]{200,100,600,4,3,2,1,200,100,600,4,3,2,1}));
//        System.out.println("38," + Solution.candies(20,new int[]{345, 1707, 8565, 2872, 4507, 4278, 517, 3261, 2699, 1514, 1800, 8287, 1488, 819, 1082, 649, 2113, 8691, 3938, 7511}));
//        System.out.println("38," + Solution.candiez(20,new int[]{345, 1707, 8565, 2872, 4507, 4278, 517, 3261, 2699, 1514, 1800, 8287, 1488, 819, 1082, 649, 2113, 8691, 3938, 7511}));
//        System.out.println("13," + Solution.candies(7,new int[]{1380, 1724, 9812, 3076, 8500, 6448, 5980}));
//        System.out.println("13," + Solution.candiez(7,new int[]{1380, 1724, 9812, 3076, 8500, 6448, 5980}));
//        System.out.println("13," + Solution.candies(7,new int[]{555, 9866, 8541, 3527, 3527, 1541, 775}));
//        System.out.println("13," + Solution.candiez(7,new int[]{555, 9866, 8541, 3527, 3527, 1541, 775}));
        Random r = new Random();
        int len = 700;
        int trial = 1000000;
        int[] nums = new int[len];
        for (int i = 0; i < trial; i++) {
            for (int j = 0; j < len; j++) {
                nums[j] = r.nextInt(10000);
            }
            long dpval = Solution.candiez(len, nums);
            long bruteVal = Solution.candies(len, nums);
            if (dpval != bruteVal) {
                System.out.println("***");
                for (int j = 0; j < len; j++) {
                    System.out.print(nums[j] + ", ");
                }
                System.out.println("***");
                break;
            }
        }

    }
}
