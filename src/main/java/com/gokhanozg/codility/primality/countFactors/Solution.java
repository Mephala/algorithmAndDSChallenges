package com.gokhanozg.codility.primality.countFactors;

class Solution {
    public int solution(int N) {
        int i = 1;
        int count = 0;
        int sqrt = (int) Math.sqrt(N);
        while (i <= sqrt) {
            if (N % i == 0) {
                count += 2;
            }
            if (i * i == N) {
                count--;
            }
            i++;
        }
        return count;
    }
}