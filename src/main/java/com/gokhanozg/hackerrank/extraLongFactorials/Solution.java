package com.gokhanozg.hackerrank.extraLongFactorials;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);
    private static Map<Integer, BigDecimal> factorials = new HashMap<>();

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
        System.out.println(calcF(n).toString());
    }

    private static BigDecimal calcF(int n) {
        if (factorials.containsKey(n)) {
            return factorials.get(n);
        }
        BigDecimal sum = BigDecimal.ONE;
        for (int i = 2; i <= n; i++) {
            sum = sum.multiply(BigDecimal.valueOf(i));
            factorials.put(i, sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
