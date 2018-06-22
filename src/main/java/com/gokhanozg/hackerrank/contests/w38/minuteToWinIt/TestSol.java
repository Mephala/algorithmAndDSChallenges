package com.gokhanozg.hackerrank.contests.w38.minuteToWinIt;

public class TestSol {

    public static void main(String[] args) {
        System.out.println("2" + Solution.minuteToWinIt(new int[]{2, 4, 6, 29, 48}, 2));
        System.out.println("2" + Solution.minuteToWinIt(new int[]{33, 88, 6, 8, 10}, 2));
        System.out.println("0" + Solution.minuteToWinIt(new int[]{2, 4, 6, 8, 10}, 2));
        System.out.println("4" + Solution.minuteToWinIt(new int[]{2, 4, 6, 8, 10}, -2));
        System.out.println("2" + Solution.minuteToWinIt(new int[]{-2, -4, -6, -66, -710}, -2));
        System.out.println("1" + Solution.minuteToWinIt(new int[]{2, 4, 87, 8, 10}, 2));
        System.out.println("4" + Solution.minuteToWinIt(new int[]{55, 33, 6, 8, 10, 88, 900}, 2));
        System.out.println("4" + Solution.minuteToWinIt(new int[]{80, 99, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 50, 66}, 2));
    }
}
