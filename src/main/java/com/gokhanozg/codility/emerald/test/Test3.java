package com.gokhanozg.codility.emerald.test;

/**
 * Created by Gokhan Ozgozen on 26-Nov-18.
 */
public class Test3 {

    public static void main(String[] args) {

    }

    private long calculateFib(int N) {
        if (N < 1) {
            return 0;
        }
        return calculateFib(N - 1) + calculateFib(N - 2);
    }
}
