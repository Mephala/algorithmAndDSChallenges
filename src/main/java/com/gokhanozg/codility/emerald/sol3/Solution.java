package com.gokhanozg.codility.emerald.sol3;

class Solution {
    public int solution(int N) {
        return N + (10 - (N % 10));
    }
}