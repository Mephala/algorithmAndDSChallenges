package com.gokhanozg.codility.sorting.MaxProductOfThree;

import java.util.PriorityQueue;

public class TestSol {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{-3, 1, 2, -2, 5, 6}));
        System.out.println(new Solution().solution(new int[]{-100, -200, 2, -2, 5, 6, 99, 199}));
        System.out.println(new Solution().solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 9, 20, 12, -1, -3, -100}));
        System.out.println(new Solution().solution(new int[]{-1, -2, -3}));
        PriorityQueue<Integer> testpq = new PriorityQueue<>();
        testpq.add(3);
        testpq.add(7);
        testpq.add(5);
        testpq.add(6);
        testpq.add(2);
        testpq.add(1);
        testpq.add(8);
        testpq.add(11);
        testpq.add(111);
        testpq.add(1111);
        System.out.println("*****************");
        for (Integer integer : testpq) {
            System.out.println(integer);
        }
        System.out.println("*****************");
        for (int i = 0; i < testpq.size(); i++) {
            System.out.println(testpq.peek());
        }
        System.out.println("*****************");
        for (int i = 0; i < testpq.size(); i++) {
            System.out.println(testpq.poll());
        }
    }
}
