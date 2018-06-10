package com.gokhanozg.codility.countingElements.maxCounters;

public class TestSol {

    public static void main(String[] args) {
        for (int i : new Solution().solution(5, new int[]{3, 4, 4, 6, 1, 4, 4})) {
            System.out.print(i);
        }
        System.out.println();
        for (int i : new Solution().solution(1, new int[]{1})) {
            System.out.print(i);
        }
        System.out.println();
        for (int i : new Solution().solution(1, new int[]{2})) {
            System.out.print(i);
        }
        System.out.println();
        for (int i : new Solution().solution(9, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10})) {
            System.out.print(i);
        }
        System.out.println();
    }
}
