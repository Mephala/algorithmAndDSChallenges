package com.gokhanozg.codility.stackAndQueue.stoneWall;

public class TestSol {

    public static void main(String[] args) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        pq.add(3);
//        pq.add(3);
//        System.out.println(pq.size());
        System.out.println(new Solution().solution(new int[]{1}));
        System.out.println(new Solution().solution(new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8}));
        System.out.println(new Solution().solution(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8}));
        System.out.println(new Solution().solution(new int[]{4, 4, 5, 5, 6, 6, 7, 7}));
    }
}
