package com.gokhanozg.fund.problems.p1;

/**
 * Created by Gokhan Ozgozen on 18-Aug-18.
 */
public class TestSol {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1, 2, 4, 3}, new int[]{1, 3, 2, 3}));
        System.out.println(new Solution().solution(new int[]{3, 2, 1, 6, 5}, new int[]{4, 2, 1, 3, 3}));
        System.out.println(new Solution().solution(new int[]{1, 2}, new int[]{1, 2}));
        System.out.println(new Solution().solution(new int[]{3, 5, 5, 3, 4}, new int[]{5, 5, 5, 5, 5}));
        System.out.println(new Solution().solution(new int[]{5, 5, 4, 3, 2, 4, 4, 5, 6, 7, 9}, new int[]{5, 5, 4, 3, 2, 4, 4, 5, 6, 7, 9}));
        System.out.println(new Solution().solution(new int[]{1, 2, 3, 4}, new int[]{1, 2, 4, 5}));
    }
}
