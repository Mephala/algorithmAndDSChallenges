package com.gokhanozg.codility.primality.minimumPerimeterRectangle;

class Solution {
    public int solution(int N) {
        int sqrt = (int) Math.sqrt(N);
        for (int i = sqrt; i > 0; i--) {
            if (N % i == 0) {
                int a = N / i;
                return 2 * (a + i);
            }
        }
        return -1; // never occur.
    }
}