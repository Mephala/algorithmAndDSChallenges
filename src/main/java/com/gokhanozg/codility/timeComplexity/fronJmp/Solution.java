package com.gokhanozg.codility.timeComplexity.fronJmp;

class Solution {
    public int solution(int X, int Y, int D) {
        int dif = Y - X;
        if (dif % D == 0) {
            return dif / D;
        } else {
            return (dif / D) + 1;
        }
    }
}