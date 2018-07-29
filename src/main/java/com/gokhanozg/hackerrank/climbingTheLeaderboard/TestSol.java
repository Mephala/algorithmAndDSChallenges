package com.gokhanozg.hackerrank.climbingTheLeaderboard;

/**
 * Created by Gokhan Ozgozen on 29-Jul-18.
 */
public class TestSol {

    public static void main(String[] args) {
//        printRanks(Solution.climbingLeaderboard(new int[]{100,90,90,80},new int[]{70,80,105}));
//        System.out.println("***");
//        printRanks(Solution.climbingLeaderboard(new int[]{100,100,50,40,40,20,10},new int[]{5,25,50,120}));
//        System.out.println("***");
        printRanks(Solution.climbingLeaderboard(new int[]{100, 90, 80, 70, 60, 50}, new int[]{30, 40, 50, 60, 65, 75, 85, 95, 99, 100, 101}));
        System.out.println("***");
    }

    static void printRanks(int[] ranks) {
        for (int rank : ranks) {
            System.out.println(rank);
        }
    }
}
