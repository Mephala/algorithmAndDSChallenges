package com.gokhanozg.codility.stackAndQueue.nesting;

/**
 * Created by Gokhan Ozgozen on 7/5/18.
 */
public class TestSol {

    public static void main(String[] args) {
        System.out.println("1," + new Solution().solution("()"));
        System.out.println("1," + new Solution().solution(""));
        System.out.println("1," + new Solution().solution("((((())))()()()()()()()()()()())"));
        System.out.println("0," + new Solution().solution("(((())))()()()()()()()()()()())"));

    }
}
