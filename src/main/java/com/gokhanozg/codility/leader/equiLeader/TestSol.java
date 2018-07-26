package com.gokhanozg.codility.leader.equiLeader;

/**
 * Created by Gokhan Ozgozen on 7/5/18.
 */
public class TestSol {
    public static void main(String[] args) {
        System.out.println("2," + new Solution().solution(new int[]{4, 3, 4, 4, 4, 2}));
        System.out.println("2," + new Solution().solution(new int[]{0, 0, 1, 1, 1, 0, 0, 1, 1, 1}));
        System.out.println("0," + new Solution().solution(new int[]{1}));
        System.out.println("0," + new Solution().solution(new int[]{1, 2}));
        System.out.println("1," + new Solution().solution(new int[]{1, 1}));
    }
}
