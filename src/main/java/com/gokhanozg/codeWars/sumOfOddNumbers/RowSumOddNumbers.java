package com.gokhanozg.codeWars.sumOfOddNumbers;

class RowSumOddNumbers {

    public static int rowSumOddNumbers(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            long start = (int) (1 + (totalElementsInPreviousRows(n) * 2));
            long end = start + (2 * (n - 1));
            return (int) ((start + end) * n / 2);
        }
    }


    private static long totalElementsInPreviousRows(int n) {
        if (n == 1) {
            return 0;
        } else {
            return (1 + n - 1) * (n - 1) / 2;
        }
    }
}