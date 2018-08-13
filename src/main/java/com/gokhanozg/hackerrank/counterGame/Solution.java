package com.gokhanozg.hackerrank.counterGame;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the counterGame function below.
    static String counterGame(long n) {
        int turn = 0;
        while (n != 1) {
            n = nextPow(n);
            turn++;
        }
        return turn % 2 == 0 ? "Richard" : "Louise";
    }

    private static boolean isPow(long n) {
        return (n & (n - 1)) == 0;
    }

    private static long nextPow(long n) {
        if (isPow(n)) {
            return n >> 1;
        } else {
            BigInteger bi = new BigInteger(Long.valueOf(n).toString());
            int len = bi.toString(2).length();
            StringBuilder sb = new StringBuilder();
            sb.append(1);
            for (int i = 1; i < len; i++) {
                sb.append(0);
            }
            long next = new BigInteger(sb.toString(), 2).longValue();
            return n - next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = counterGame(n);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
