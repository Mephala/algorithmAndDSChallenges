package com.gokhanozg.hackerrank.contests.w38.minuteToWinIt;

import java.util.*;

public class TestSol {

    public static void main(String[] args) {
//        System.out.println("2" + Solution.minuteToWinIt(new int[]{2, 4, 6, 29, 48}, 2));
//        System.out.println("2" + Solution.minuteToWinIt(new int[]{33, 88, 6, 8, 10}, 2));
//        System.out.println("0" + Solution.minuteToWinIt(new int[]{2, 4, 6, 8, 10}, 2));
//        System.out.println("4" + Solution.minuteToWinIt(new int[]{2, 4, 6, 8, 10}, -2));
//        System.out.println("2" + Solution.minuteToWinIt(new int[]{-2, -4, -6, -66, -710}, -2));
//        System.out.println("1" + Solution.minuteToWinIt(new int[]{2, 4, 87, 8, 10}, 2));
//        System.out.println("4" + Solution.minuteToWinIt(new int[]{55, 33, 6, 8, 10, 88, 900}, 2));
//        System.out.println("4" + Solution.minuteToWinIt(new int[]{80, 99, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 50, 66}, 2));
//        System.out.println("3" + Solution.minuteToWinIt(new int[]{10, 12, 14, 16, 100, 102, 104}, 2));
//        System.out.println("6" + Solution.minuteToWinIt(new int[]{10, 12, 14, 16, 100, 102, 104}, -9999));
//        System.out.println("0" + Solution.minuteToWinIt(new int[]{-100, -200}, -100));
//        System.out.println("1" + Solution.minuteToWinIt(new int[]{2, 2}, -100));


//        System.out.println("2" + Solution.minuteToWinIt(new int[]{1, 2, 2, 2, 2, 2, 2, 2, 1}, 0));
//        System.out.println("6" + Solution.minuteToWinIt(new int[]{2, 4, 6, 8, 14, 16, 18, 100, 102, 104}, 2));
        for (int p = 0; p < 10000; p++) {
            Random r = new Random();
            final int size = (int) r.nextInt((int) 1E5);
            int[] A = new int[(int) size];
            int k = (int) (r.nextInt((int) (1E5 + 1 + 1E5)) - 1E5);

            int start = (int) -size;
            A[0] = start;
            for (int i = 1; i < A.length; i++) {
                A[i] = A[i - 1] + k;
            }
            int sol = r.nextInt(size / 2);
            Set<Integer> changedIndexes = new HashSet<>();
            for (int i = 0; i < sol; i++) {
                int randomInt = (int) (r.nextInt((int) (1E5 + 1 + 1E5)) - 1E5);
                int randomIndex = r.nextInt(size);
                while (changedIndexes.contains(randomIndex))
                    randomIndex = r.nextInt(size);
                changedIndexes.add(randomIndex);
                while (A[randomIndex] == randomInt) {
                    randomInt = (int) (r.nextInt((int) (1E5 + 1 + 1E5)) - 1E5);
                }
                A[randomIndex] = randomInt;
            }
            System.out.println(sol + "," + Solution.minuteToWinIt(A, k));
        }

        int[] B = {-30, -20, 14, 0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 7, 190, 200, 210, 220, 90, 240, 250, 260};
        System.out.println("3," + Solution.minuteToWinIt(B, 10));

    }
}
