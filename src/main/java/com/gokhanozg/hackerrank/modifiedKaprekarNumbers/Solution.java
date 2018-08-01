package com.gokhanozg.hackerrank.modifiedKaprekarNumbers;

import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {
        StringBuilder sb = new StringBuilder();
        boolean exist = false;
        for (int i = p; i <= q; i++) {
            if (isKaprekar(i)) {
                sb.append(i + " ");
                exist = true;
            }
        }
        if (!exist) {
            System.out.println("INVALID RANGE");
        } else {
            String printVal = sb.toString().trim();
            System.out.println(printVal);
        }

    }

    private static boolean isKaprekar(int n) {
        int d = Integer.valueOf(n).toString().length();
        long square = (long) Math.pow(n, 2);
        String sqs = Long.valueOf(square).toString();
        int index = sqs.length() - d;
        String p1 = sqs.substring(index);
        String p2 = sqs.substring(0, index);
        if ("".equals(p2)) {
            return Integer.parseInt(p1) == n;
        }
        return (Integer.parseInt(p1) + Integer.parseInt(p2)) == n;
    }

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
