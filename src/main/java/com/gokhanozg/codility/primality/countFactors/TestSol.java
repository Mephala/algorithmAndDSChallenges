package com.gokhanozg.codility.primality.countFactors;

/**
 * Created by Mephalay on 11-Jul-18.
 */
public class TestSol {

    public static void main(String[] args) {
        System.out.println("8," + new Solution().solution(24));
        System.out.println("1," + new Solution().solution(1));
        System.out.println("2," + new Solution().solution(2));
        System.out.println("3," + new Solution().solution(4));
        System.out.println("2," + new Solution().solution(5));
        System.out.println("4," + new Solution().solution(8));
        System.out.println("5," + new Solution().solution(16));
    }
}
